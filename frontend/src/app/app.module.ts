import {NgModule} from '@angular/core';
import {BrowserModule, provideClientHydration} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CandidateService} from "./core/services/candidate/candidate.service";
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from "./home/home.component";
import {NavbarComponent} from "./shared/components/navbar/navbar.component";
import {FormsModule} from "@angular/forms";
import {NgToastModule} from "ng-angular-popup";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgToastModule,
  ],
  providers: [provideClientHydration(), CandidateService],
  bootstrap: [AppComponent]
})
export class AppModule { }
