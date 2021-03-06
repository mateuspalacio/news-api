package br.unifor.newsapi.service;

import br.unifor.newsapi.model.Category;
import br.unifor.newsapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category item) {
        return categoryRepository.save(item);
    }

    public Category getOne(int id) {
        return categoryRepository.findOne(id);
    }

    public Category update(int id, Category item){
        Category category = categoryRepository.findOne(id);
        category.setName(item.getName());
        return categoryRepository.save(category);
    }

    public void delete(int id) {
        Category category = categoryRepository.findOne(id);
        categoryRepository.delete(category);
    }
}
