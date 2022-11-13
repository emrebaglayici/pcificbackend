package com.pcific.pcificbackend.Repositories;

import com.pcific.pcificbackend.Entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags,Long> {
    boolean existsById(Long id);
}
