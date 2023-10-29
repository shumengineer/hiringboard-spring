package shm.web.dto;/* 
    Author: @shumengineer
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public class JobDTO {
    @JsonProperty("id")
    private UUID id;

    @NotEmpty
    @Size(min = 2, max = 30, message = "Name should have at least 2 and less then 30 characters")
    @JsonProperty("name")
    private String name;

    @NotEmpty
    @Size(min = 2, max = 60, message = "description should have at least 2 and less then 60 characters")
    @JsonProperty("description")
    private String description;

    @NotNull
    @JsonProperty("hiring")
    private Boolean hiring;
    @JsonProperty("candidates")
    private List<CandidateDTO> candidates;

    @Override
    public String toString() {
        return "JobDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hiring=" + hiring +
                ", candidates=" + candidates +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHiring() {
        return hiring;
    }

    public void setHiring(Boolean hiring) {
        this.hiring = hiring;
    }

    public List<CandidateDTO> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<CandidateDTO> candidates) {
        this.candidates = candidates;
    }
}