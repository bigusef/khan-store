package com.bigusef.khan.catalog.service;

import com.bigusef.khan.catalog.domain.Category;
import com.bigusef.khan.catalog.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository catRep;

    public List<Category> getALl() {
        return catRep.findAll();
    }

    public List<Category> getParentOnly() {
        return catRep.findAllByParentIsNull();
    }

    public List<Category> getAllActive() {
        return catRep.findAllByLockedIsFalse();
    }

    public Category getCategory(Long id) {
        return catRep.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Category cat) {
        catRep.save(cat);
    }
}
