package com.pcific.pcificbackend.Repositories;

import com.pcific.pcificbackend.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
