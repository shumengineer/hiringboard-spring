import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Candidate} from "../../../shared/models/candidate";
import {environment} from "../../../../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  constructor(private http: HttpClient) { }
  public getCandidates(): Observable<Candidate[]>{
    return this.http.get<Candidate[]>(environment.apiServerUrl + "/candidates/all");
  }

  public getCandidate(id: string): Observable<Candidate>{
    return this.http.get<Candidate>(environment.apiServerUrl + `/candidates/find/${id}`);
  }
  public addCandidate(candidate: Candidate): Observable<Candidate>{
    return this.http.post<Candidate>(environment.apiServerUrl + "/candidates/add", candidate);
  }

  public updateCandidate(candidate: Candidate): Observable<Candidate>{
    return this.http.put<Candidate>(environment.apiServerUrl + "/candidates/update", candidate);
  }
  public deleteCandidate(id: string): Observable<void>{
    return this.http.delete<void>(environment.apiServerUrl + `/candidates/delete/${id}`);
  }
}
