package shm.web.models;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@DynamicUpdate
@Table(name = "jobs")
public class Job implements Serializable {
    public Job(){}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, updatable = true)
    private String name;

    @Column(name = "description", nullable = false, updatable = true)
    private String description;

    @Column(nullable = false, updatable = true)
    private Boolean hiring;

    @OneToMany(
            mappedBy = "job",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Candidate> candidates;

    public Job(UUID id, String name, String description, Boolean hiring, List<Candidate> candidates) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hiring = hiring;
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "Job{" +
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

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
}
