package com.bigusef.khan.catalog.repository;

import com.bigusef.khan.catalog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByParentIsNull();

    List<Category> findAllByLockedIsFalse();
}
