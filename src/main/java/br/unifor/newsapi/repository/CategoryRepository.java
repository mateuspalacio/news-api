package br.unifor.newsapi.repository;

import br.unifor.newsapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query(value = "SELECT * FROM category", nativeQuery = true)
    List<Category> findAll();

    @Query(value = "SELECT * FROM category WHERE id = ?1", nativeQuery = true)
    Category findOne(int id);
}
