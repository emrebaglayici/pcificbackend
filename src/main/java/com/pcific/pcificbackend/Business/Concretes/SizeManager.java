package com.pcific.pcificbackend.Business.Concretes;

import com.pcific.pcificbackend.Business.Abstracts.ISizeService;
import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Repositories.SizeRepository;
import com.pcific.pcificbackend.Web.Dtos.SizesDto.SizeCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class SizeManager implements ISizeService {
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public Page<Size> listSizes(Pageable pageable) {
        return this.sizeRepository.findAll(pageable);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void createSize(SizeCreateDto size) {
        this.sizeRepository.save(size.toSize());
    }

    @Override
    public Optional<Size> getById(Long id) {
        return sizeRepository.findById(id);
    }
    public boolean isExists(Long id){
        return sizeRepository.existsById(id);
    }

    @Override
    public Size deleteById(Long id) {
        Optional<Size> optionalSize=sizeRepository.findById(id);
        Size size=optionalSize.orElseThrow(()->new NotFoundException("Size not found"));
        this.sizeRepository.deleteById(size.getId());
        return size;
    }

    @Override
    public void update(Long id, Size size) {
        this.sizeRepository.save(size);
    }
}
