package shm.web;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shm.web.dto.JobDTO;
import shm.web.mappers.MapStructMapper;
import shm.web.models.Job;
import shm.web.services.JobService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobResource {
    private final JobService jobService;
    private final MapStructMapper mapstructMapper;

    public JobResource(JobService jobService, MapStructMapper mapstructMapper) {
        this.jobService = jobService;
        this.mapstructMapper = mapstructMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobDTO>> getAll() {
        return new ResponseEntity<>(mapstructMapper.fromJobs(jobService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(mapstructMapper.fromJob(jobService.findJobById(id)), HttpStatus.OK);
    }

    @GetMapping("/hiring/{hiring}")
    public ResponseEntity<List<JobDTO>> getJobsByHiring(@PathVariable(value = "hiring") Boolean hiring) {
        return new ResponseEntity<>(this.mapstructMapper.fromJobs(jobService.findByHiring(hiring)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") UUID id) {
        jobService.removeJobById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<JobDTO> updateJob(@Valid @RequestBody JobDTO dto) {
        return new ResponseEntity<>(this.mapstructMapper.fromJob(jobService.updateJobPartial(dto)), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Job> addJob(@Valid @RequestBody Job job) {
        System.out.println(job);
        return new ResponseEntity<>(jobService.addJob(job), HttpStatus.CREATED);
    }
}