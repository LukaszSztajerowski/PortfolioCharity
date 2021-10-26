package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> readCategory(Long id) {
        return categoryRepository.findById(id);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Optional<Category> categoryById = categoryRepository.findById(id);
        if (categoryById.isPresent()) {
            categoryRepository.deleteById(id);
        }
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
