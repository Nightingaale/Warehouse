package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.event.ProductsEvent;
import org.app.storage.models.Products;
import org.app.storage.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsListener {

    private final ProductRepository productRepository;

    public static ProductsEvent ToDTO(Products products) {
        return new ProductsEvent(
                products.getProductId(),
                products.getCategoryId(),
                products.getProductName(),
                products.getProductDescription(),
                products.getAddedAt(),
                products.getUpdatedAt()
        );
    }

    public static Products ToEntity(ProductsEvent productsEvent) {
        Products products = new Products();
        products.setProductId(productsEvent.getProductId());
        products.setCategoryId(productsEvent.getCategoryId());
        products.setProductName(productsEvent.getProductName());
        products.setProductDescription(productsEvent.getProductDescription());
        products.setAddedAt(productsEvent.getAddedAt());
        products.setUpdatedAt(productsEvent.getUpdatedAt());
        return products;
    }


    public Optional<Products> getFullProductsInfo(Long id) {
        Optional<Products> productInfo = productRepository.findById(id);

        if (productInfo.isEmpty()) {
            return Optional.empty();
        }
        Products product = productInfo.get();
        Products DTO = convertToDto(product);
        return Optional.of(DTO);
    }

    public static Products convertToDto(Products product) {
        return new Products(
                product.getProductId(),
                product.getCategoryId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getAddedAt(),
                product.getUpdatedAt()
        );
    }
}
