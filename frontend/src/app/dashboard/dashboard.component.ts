import {Component, OnInit} from '@angular/core';
import {Candidate} from "../shared/models/candidate";
import {CandidateService} from "../core/services/candidate/candidate.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgToastService} from "ng-angular-popup";
import {BehaviorSubject} from "rxjs";
import {JobService} from "../core/services/job/job.service";
import {Job} from "../shared/models/job";

interface State {
  candidates: Candidate[] | null;
  loaded: boolean;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnInit {
  showCandidateForm: boolean = false;
  showJobForm: boolean = false;
  isEdit: boolean = false;
  selectedCandidate: Candidate | null = null;
  selectedJob: Job | null = null;

  state$ = new BehaviorSubject<State>({
    candidates: null,
    loaded: false,
  });

  jobs$ = new BehaviorSubject({
    data: [] as Job[] | null
  });

  constructor(private candidateService: CandidateService, private toast: NgToastService, private jobService: JobService) {
  }

  ngOnInit() {
    this.getCandidates();
    this.getJobs();
  }

  public getJobs(): void {
    this.jobService.getJobs().subscribe({
      next: (res: Job[]) => {
        this.jobs$.next({data: res});
      }
    });
  }

  public getCandidates(): void {
    this.candidateService.getCandidates().subscribe({
      next: (resp: Candidate[]) => this.state$.next({candidates: resp, loaded: true}),
      error: (error: HttpErrorResponse) => console.warn(error.message)
    });
  }

  editCandidate(candidate: Candidate) {
    this.selectedCandidate = candidate;
    this.showCandidateForm = true;
    this.isEdit = true;
  }


  editJob(job: Job) {
    this.selectedJob = job;
    this.showJobForm = true;
    this.isEdit = true;
  }
  deleteJob(job: Job) {
    if (!job?.id) return;
    this.jobService.deleteJob(job.id).subscribe(
      {
        complete: () => {
          this.toast.success({detail: "Deleted."});
          this.handleSubmit();
        },
        error: (err) => this.toast.error({detail: "Error.", summary: err?.message})
      }
    );
  }

  deleteCandidate(candidate: Candidate) {
    if (!candidate?.id) return;
    this.candidateService.deleteCandidate(candidate.id).subscribe(
      {
        complete: () => {
          this.toast.success({detail: "Deleted."});
          this.handleSubmit();
        },
        error: (err) => this.toast.error({detail: "Error.", summary: err?.message})
      }
    );
  }

  cancel() {
    this.selectedCandidate = null;
    this.selectedJob = null;
    this.isEdit = false;
    this.showCandidateForm = false;
    this.showJobForm = false;
  }

  handleSubmit() {
    this.getCandidates();
    this.getJobs();
    this.cancel();
  }
}
