package com.pcific.pcificbackend.Repositories;

import com.pcific.pcificbackend.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Page<Product> findAllByActiveTrue(Pageable pageable);
}
