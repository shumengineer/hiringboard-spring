package shm.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shm.web.models.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobRepo extends JpaRepository<Job, UUID> {
    void deleteJobById(UUID id);

    Optional<Job> findJobById(UUID id);

    List<Job> findByHiring(Boolean hiring);
}
