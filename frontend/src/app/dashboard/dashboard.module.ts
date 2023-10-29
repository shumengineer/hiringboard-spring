import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {DashboardRoutingModule} from './dashboard-routing.module';
import {DashboardComponent} from "./dashboard.component";
import {CandidateFormComponent} from "../shared/components/candidate-form/candidate-form.component";
import {FormsModule} from "@angular/forms";
import {JobFormComponent} from "../shared/components/job-form/job-form.component";


@NgModule({
  declarations: [
    DashboardComponent,
    CandidateFormComponent,
    JobFormComponent
  ],
  exports: [
    CandidateFormComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule
  ]
})
export class DashboardModule { }
