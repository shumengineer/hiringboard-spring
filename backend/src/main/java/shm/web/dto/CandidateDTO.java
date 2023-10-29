package shm.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class CandidateDTO {
    @JsonProperty("id")
    private UUID id;
    @NotEmpty
    @Size(min = 2, max = 16, message = "Name should have at least 2 and less then 16 characters")
    @JsonProperty("name")
    private String name;
    @NotEmpty
    @Email
    @JsonProperty("email")
    private String email;
    @JsonProperty(value = "job", required = false)
    private UUID job;

    @Override
    public String toString() {
        return "CandidateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
//                ", job=" + job +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getJob() {
        return job;
    }

    public void setJob(UUID job) {
        this.job = job;
    }
}