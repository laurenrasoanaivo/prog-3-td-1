package app.prog.service;

import app.prog.model.CategoryEntity;
import app.prog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<CategoryEntity> getCategories() {
        return repository.findAll();
    }

    public List<CategoryEntity> createCategories(List<CategoryEntity> toCreate) {
        return repository.saveAll(toCreate);
    }


    public CategoryEntity deleteCategory(int id) {
        Optional<CategoryEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CategoryEntity." + id + " not found");
        }
    }
}
