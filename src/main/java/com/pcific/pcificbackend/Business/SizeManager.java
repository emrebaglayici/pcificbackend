package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SizeManager implements ISizeService{
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public Size createSize(Size size) {
        return this.sizeRepository.save(size);
    }

    @Override
    public Optional<Size> getById(Long id) {
        return sizeRepository.findById(id);
    }
}
