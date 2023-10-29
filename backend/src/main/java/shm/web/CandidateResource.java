package shm.web;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shm.web.dto.CandidateDTO;
import shm.web.mappers.CandidateMapper;
import shm.web.models.Candidate;
import shm.web.services.CandidateService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/candidates")
public class CandidateResource {
    private final CandidateService candidateService;
    private final CandidateMapper candidateMapper;

    public CandidateResource(CandidateService candidateService, CandidateMapper candidateMapper) {
        this.candidateService = candidateService;
        this.candidateMapper = candidateMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
        List<CandidateDTO> candidates = candidateMapper.fromCandidates(candidateService.findAllCandidates());
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") UUID id) {
        Candidate candidate = candidateService.findCandidateById(id);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CandidateDTO> addCandidate(@Valid @RequestBody CandidateDTO dto) {
        Candidate candidate = this.candidateMapper.toCandidate(dto);
        CandidateDTO resp = this.candidateMapper.fromCandidate(candidateService.addCandidate(candidate));

        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CandidateDTO> updateCandidate(@Valid @RequestBody CandidateDTO candidate) {
        Candidate newCandidate = candidateService.updateCandidate(candidateMapper.toCandidate(candidate));
        return new ResponseEntity<>(candidateMapper.fromCandidate(newCandidate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable("id") UUID id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
