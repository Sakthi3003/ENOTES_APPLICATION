package com.enotes.Enotes.repository;

import com.enotes.Enotes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,String> {

    Optional<Category> findByIdAndIsDeletedFalse(String categoryId);

    List<Category> findByIsActiveTrueAndIsDeletedFalse();

    List<Category> findByIsDeletedFalse();
}
