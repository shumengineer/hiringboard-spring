package shm.web.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import shm.web.dto.JobDTO;
import shm.web.models.Job;

import java.util.List;

@Mapper(
        componentModel = "spring", uses = CandidateMapper.class
)
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    Job toJob(JobDTO jobDTO);

    JobDTO fromJob(Job job);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateJobFromDto(JobDTO dto, @MappingTarget Job entity);
    List<JobDTO> fromJobs(List<Job> jobs);
}