package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Category;
import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Entities.Tags;
import com.pcific.pcificbackend.Exceptions.FillTheBlanksException;
import com.pcific.pcificbackend.Exceptions.MustBeGraterThanZero;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Repositories.ProductRepository;
import com.pcific.pcificbackend.Web.Dtos.ProductCreateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductManager implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TagManager tagManager;

    @Autowired
    private CategoryManager categoryManager;

    @Autowired
    private SizeManager sizeManager;

    @Override
    public void saveProduct(ProductCreateDto dto) {
        if (dto.getPrice()<0)
            throw new MustBeGraterThanZero("Price must be grater than zero!");
        if (dto.getQuantity()<0)
            throw new MustBeGraterThanZero("Quantity must be grater than zero!");
        if (dto.getName().isEmpty())
            throw new FillTheBlanksException("Name cannot be empty");

        List<Tags> tags = dto.getTags().stream()
                .map(id -> tagManager.getById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        if (tags.size() != dto.getTags().size())
            throw new NotFoundException("Tags are not found");

        List<Category> categories = dto.getCategories().stream()
                .map(id -> categoryManager.getById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        List<Size> sizes = dto.getSizes().stream()
                .map(id -> sizeManager.getById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        if (categories.size() != dto.getCategories().size())
            throw new NotFoundException("Categories are not found");
        productRepository.save(
                Product.builder()
                        .name(dto.getName())
                        .price(dto.getPrice())
                        .shortDescription(dto.getShortDescription())
                        .longDescription(dto.getLongDescription())
                        .quantity(dto.getQuantity())
                        .active(dto.getActive())
                        .category(categories)
                        .tags(tags)
                        .sizes(sizes)
                        .build()
        );
    }

    @Override
    public Page<Product> listProducts(Pageable pageable) {
        return this.productRepository.findAllByActiveTrue(pageable);
    }
}
