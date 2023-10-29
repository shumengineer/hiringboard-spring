import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../../environment/environment";
import {Job} from "../../../shared/models/job";

@Injectable({
  providedIn: 'root'
})
export class JobService {

  constructor(private http: HttpClient) {
  }

  public getJobs(): Observable<Job[]> {
    return this.http.get<Job[]>(environment.apiServerUrl + "/jobs/all");
  }

  public getJob(id: string): Observable<Job> {
    return this.http.get<Job>(environment.apiServerUrl + `/jobs/find/${id}`);
  }

  public addJob(job: Job): Observable<Job> {
    return this.http.post<Job>(environment.apiServerUrl + "/jobs/add", job);
  }

  public updateJob(job: Job): Observable<Job> {
    return this.http.put<Job>(environment.apiServerUrl + "/jobs/update", job);
  }

  public deleteJob(id: string): Observable<void> {
    return this.http.delete<void>(environment.apiServerUrl + `/jobs/delete/${id}`);
  }
}
