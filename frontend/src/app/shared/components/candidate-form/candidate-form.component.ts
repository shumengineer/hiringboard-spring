import {Component, EventEmitter, Input, OnChanges, Output, SimpleChanges} from '@angular/core';
import {Candidate} from "../../models/candidate";
import {Job} from "../../models/job";
import {CandidateService} from "../../../core/services/candidate/candidate.service";
import {NgToastService} from "ng-angular-popup";
import {JobService} from "../../../core/services/job/job.service";

@Component({
  selector: 'candidate-form',
  templateUrl: './candidate-form.component.html',
})
export class CandidateFormComponent implements OnChanges {
  candidateDefaults = {name: '', email: '', job: {} as Job};
  candidateForm: Candidate = this.candidateDefaults;

  @Input() jobs: Job[] | null = [];
  @Input() edit = false;
  @Input() selectedCandidate: Candidate | null = null;

  @Output() onChange = new EventEmitter<any>();
  @Output() onClose = new EventEmitter<any>();

  constructor(private candidateService: CandidateService, private toast: NgToastService, private jobService: JobService) {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes["edit"]?.currentValue === true && changes["selectedCandidate"]?.currentValue && this.selectedCandidate) {
      this.candidateForm = this.selectedCandidate;
    }
  }

  handleChange() {
    this.onChange.emit();
    this.edit = false;
  }

  clearForm() {
    this.candidateForm = this.candidateDefaults;
    this.edit = false;
    this.onClose.emit();
  }

  createCandidate() {
    this.candidateService.addCandidate(this.candidateForm).subscribe(
      {
        complete: () => {
          this.selectedCandidate = this.candidateDefaults;
          this.toast.success({
            detail: "Created.",
            summary: `The candidate ${this.selectedCandidate.name} was successfully created`
          });
          this.clearForm();
          this.handleChange();
        },
        error: (err) => this.toast.error({detail: "Error.", summary: err?.message})
      }
    );
  }

  updateCandidate() {
    this.candidateService.updateCandidate(this.candidateForm).subscribe(
      {
        complete: () => {
          this.toast.success({detail: "Updated."});
          this.clearForm();
          this.handleChange();
        },
        error: (err) => this.toast.error({detail: "Error.", summary: err?.message})
      }
    );
  }
}
