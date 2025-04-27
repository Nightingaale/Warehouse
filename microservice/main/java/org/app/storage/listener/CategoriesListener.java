package org.app.storage.listener;

import lombok.RequiredArgsConstructor;
import org.app.storage.event.CategoriesEvent;
import org.app.storage.models.Categories;
import org.app.storage.repo.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriesListener {

    private final CategoriesRepository categoriesRepository;

    public static CategoriesEvent ToDto(Categories categories) {
        return new CategoriesEvent(
                categories.getCategoryId(),
                categories.getCategoryName(),
                categories.getCategoryDescription()
        ) ;
    }

    public static Categories ToEntity(CategoriesEvent categoriesEvent) {
        Categories categories = new Categories();
        categories.setCategoryId(categoriesEvent.getCategoryId());
        categories.setCategoryName(categoriesEvent.getCategoryName());
        categories.setCategoryDescription(categoriesEvent.getCategoryDescription());
        return categories;
    }


    public Optional<Categories> getFullCategoryInfo(Long id) {
        Optional<Categories> categoryOptional = categoriesRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            return Optional.empty();
        }
        Categories category = categoryOptional.get();
        Categories DTO = convertToProfileDto(category);
        return Optional.of(DTO);
    }

    public static Categories convertToProfileDto(Categories categories) {
        return new Categories(
                categories.getCategoryId(),
                categories.getCategoryName(),
                categories.getCategoryDescription()
        );
    }
}
