package shm.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shm.web.dto.JobDTO;
import shm.web.exceptions.JobNotFoundException;
import shm.web.mappers.MapStructMapper;
import shm.web.models.Job;
import shm.web.repo.JobRepo;

import java.util.List;
import java.util.UUID;


@Service
public class JobService {
    private final JobRepo jobRepo;
    private final MapStructMapper mapstructMapper;

    @Autowired
    public JobService(JobRepo jobRepo,  MapStructMapper mapstructMapper) {
        this.jobRepo = jobRepo; this.mapstructMapper = mapstructMapper;
    }

    public Job findJobById(UUID id) {
        return jobRepo.findJobById(id).orElseThrow(() -> new JobNotFoundException("Job by id not found."));
    }

    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    public List<Job> findByHiring(Boolean hiring) {
        return jobRepo.findByHiring(hiring);
    }

    public Job addJob(Job job) {
        return jobRepo.save(job);
    }

    public Job updateJob(Job job) {
        return jobRepo.save(job);
    }
    public Job updateJobPartial(JobDTO dto) {
        Job job = jobRepo.findById(dto.getId()).orElseThrow(() -> new JobNotFoundException("Job by id not found."));
        mapstructMapper.updateJobFromDto(dto, job);
        return jobRepo.save(job);
    }
    @Transactional
    public void removeJobById(UUID id) {
        jobRepo.deleteJobById(id);
    }
}
