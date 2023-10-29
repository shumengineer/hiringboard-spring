package shm.web.mappers;

import org.mapstruct.Mapper;
import shm.web.dto.CandidateDTO;
import shm.web.models.Candidate;
import shm.web.models.Job;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    default Job map(UUID value) {
        Job j = new Job();
        j.setId(value);
        return j;
    }
    default UUID map(Job job) {
        return job.getId();
    }

    CandidateDTO fromCandidate(Candidate candidate);

    Candidate toCandidate(CandidateDTO candidate);

    List<CandidateDTO> fromCandidates(List<Candidate> candidates);
}