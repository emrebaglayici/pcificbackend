package com.pcific.pcificbackend.Repositories;

import com.pcific.pcificbackend.Entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size,Long> {
    boolean existsById(Long id);
}
