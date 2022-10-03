package com.pcific.pcificbackend.Business;
import com.pcific.pcificbackend.Entities.Size;

import java.util.Optional;

public interface ISizeService {

    Size createSize(Size size);
    Optional<Size> getById(Long id);
}
