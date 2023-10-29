import {Candidate} from "./candidate";

export interface Job{
  id?: string;
  name: string;
  hiring: boolean;
  description: string;
  candidates?: Candidate[] | null;
}
