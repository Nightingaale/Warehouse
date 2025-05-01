package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.dto.ProductsDto;
import org.app.storage.entity.ProductsEntity;
import org.app.storage.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsListener {

    private final ProductRepository productRepository;

    public static ProductsDto ToDTO(ProductsEntity products) {
        return new ProductsDto(
                products.getProductId(),
                products.getCategoryId(),
                products.getProductName(),
                products.getProductDescription(),
                products.getAddedAt(),
                products.getUpdatedAt()
        );
    }

    public static ProductsEntity ToEntity(ProductsDto productsEvent) {
        ProductsEntity products = new ProductsEntity();
        products.setProductId(productsEvent.getProductId());
        products.setCategoryId(productsEvent.getCategoryId());
        products.setProductName(productsEvent.getProductName());
        products.setProductDescription(productsEvent.getProductDescription());
        products.setAddedAt(productsEvent.getAddedAt());
        products.setUpdatedAt(productsEvent.getUpdatedAt());
        return products;
    }


    public Optional<ProductsEntity> getFullProductsInfo(Long id) {
        Optional<ProductsEntity> productInfo = productRepository.findById(id);

        if (productInfo.isEmpty()) {
            return Optional.empty();
        }
        ProductsEntity product = productInfo.get();
        ProductsEntity DTO = convertToDto(product);
        return Optional.of(DTO);
    }

    public static ProductsEntity convertToDto(ProductsEntity product) {
        return new ProductsEntity(
                product.getProductId(),
                product.getCategoryId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getAddedAt(),
                product.getUpdatedAt()
        );
    }
}
