package shm.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shm.web.models.Candidate;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepo extends JpaRepository<Candidate, UUID> {
    void deleteCandidateById(UUID id);

    Optional<Candidate> findCandidateById(UUID id);

}
