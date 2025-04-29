package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.dto.CategoriesDto;
import org.app.storage.entity.CategoriesEntity;
import org.app.storage.repo.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriesListener {

    private final CategoriesRepository categoriesRepository;

    public static CategoriesDto ToDto(CategoriesEntity categories) {
        return new CategoriesDto(
                categories.getCategoryId(),
                categories.getCategoryName(),
                categories.getCategoryDescription()
        ) ;
    }

    public static CategoriesEntity ToEntity(CategoriesDto categoriesEvent) {
        CategoriesEntity categories = new CategoriesEntity();
        categories.setCategoryId(categoriesEvent.getCategoryId());
        categories.setCategoryName(categoriesEvent.getCategoryName());
        categories.setCategoryDescription(categoriesEvent.getCategoryDescription());
        return categories;
    }


    public Optional<CategoriesEntity> getFullCategoryInfo(Long id) {
        Optional<CategoriesEntity> categoryOptional = categoriesRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            return Optional.empty();
        }
        CategoriesEntity category = categoryOptional.get();
        CategoriesEntity DTO = convertToProfileDto(category);
        return Optional.of(DTO);
    }

    public static CategoriesEntity convertToProfileDto(CategoriesEntity categories) {
        return new CategoriesEntity(
                categories.getCategoryId(),
                categories.getCategoryName(),
                categories.getCategoryDescription()
        );
    }
}
