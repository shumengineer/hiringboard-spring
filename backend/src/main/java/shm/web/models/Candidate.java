package shm.web.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {
    public Candidate() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, updatable = true)
    private String name;
    @Column(nullable = false, updatable = true)
    private String email;


//    @JoinColumn(name = "job_id", updatable = true, nullable = true)
//    @Column(nullable = false, updatable = true)
//    @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
    @JoinColumn(name = "job_id", referencedColumnName = "id", updatable = true, nullable = true)
    private Job job;

    public Candidate(UUID id, String name, String email, Job job) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", job=" + job +
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
