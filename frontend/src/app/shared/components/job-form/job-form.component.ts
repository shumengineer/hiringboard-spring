import {Component, EventEmitter, Input, OnChanges, Output, SimpleChanges} from '@angular/core';
import {Job} from "../../models/job";
import {NgToastService} from "ng-angular-popup";
import {JobService} from "../../../core/services/job/job.service";

@Component({
  selector: 'job-form',
  templateUrl: './job-form.component.html',
})
export class JobFormComponent implements OnChanges {
  jobFormDefaults: Job = {name: "", description: "", hiring: true};
  jobForm: Job = this.jobFormDefaults;

  @Input() edit = false;
  @Input() selectedJob: Job | null = null;
  @Output() onChange = new EventEmitter<any>();
  @Output() onClose = new EventEmitter<any>();

  constructor(private toast: NgToastService, private jobService: JobService) {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes["edit"]?.currentValue && changes["selectedJob"]?.currentValue && this.selectedJob) this.jobForm = this.selectedJob;
  }

  handleChange() {
    this.onChange.emit();
    this.jobForm = this.jobFormDefaults;
  }

  clearForm() {
    this.jobForm = this.jobFormDefaults;
    this.edit = false;
    this.onClose.emit();
  }

  createJob() {
    if (!this.jobForm.name || !this.jobForm.description) return;

    this.jobService.addJob(this.jobForm).subscribe(
      {
        complete: () => {
          this.toast.success({detail: "Created.", summary: `${this.jobForm.name} was successfully created`});
          this.handleChange();
        },
        error: (err) => this.toast.error({detail: "Error.", summary: err?.message})
      }
    );
  }

  handleUpdateJob() {
    this.jobForm.candidates = null;
    this.jobService.updateJob(this.jobForm).subscribe(
      {
        complete: () => {
          this.toast.success({detail: "Updated."});
          this.handleChange();
        },
        error: (err) => this.toast.error({detail: "Error.", summary: err?.message})
      }
    );
  }
}
