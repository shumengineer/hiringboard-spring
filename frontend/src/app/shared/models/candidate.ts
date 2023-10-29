import {Job} from "./job";

export interface Candidate{
  id?: string;
  name: string;
  email: string;
  job?: Job;
}
