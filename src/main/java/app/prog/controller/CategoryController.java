package app.prog.controller;

import app.prog.model.CategoryEntity;
import app.prog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/categories")
    public List<CategoryEntity> getCategory() {
        return service.getCategories();
    }

    @PostMapping("/categories")
    public List<CategoryEntity> createCategories(@RequestBody List<CategoryEntity> toCreate) {
        return service.createCategories(toCreate);
    }


    @DeleteMapping("/categories/{id}")
    public CategoryEntity deleteBook(@PathVariable int id) {
        return service.deleteCategory(id);
    }
}
