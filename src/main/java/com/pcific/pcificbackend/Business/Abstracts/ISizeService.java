package com.pcific.pcificbackend.Business.Abstracts;
import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Web.Dtos.SizesDto.SizeCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISizeService {

    Page<Size> listSizes(Pageable pageable);
    void createSize(SizeCreateDto size);
    Optional<Size> getById(Long id);
    Size deleteById(Long id);
    void update(Long id,Size size);

    boolean isExists(Long id);
}
