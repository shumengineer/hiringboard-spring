package shm.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shm.web.exceptions.CandidateNotFoundException;
import shm.web.models.Candidate;
import shm.web.repo.CandidateRepo;

import java.util.List;
import java.util.UUID;

@Service
public class CandidateService {
    private final CandidateRepo candidateRepo;

    @Autowired
    public CandidateService(CandidateRepo candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    public List<Candidate> findAllCandidates(){
        return candidateRepo.findAll();
    }

    public Candidate addCandidate(Candidate candidate){
        return candidateRepo.save(candidate);
    }

    public Candidate updateCandidate(Candidate candidate){
        return candidateRepo.save(candidate);
    }
    public Candidate findCandidateById(UUID id){
        return candidateRepo.findCandidateById(id).orElseThrow(() -> new CandidateNotFoundException("Candidate not found by id."));
    }

    @Transactional
    public void deleteCandidate(UUID id){
        candidateRepo.deleteCandidateById(id);
    }

}
