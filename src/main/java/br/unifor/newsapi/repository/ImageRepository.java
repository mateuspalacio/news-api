package br.unifor.newsapi.repository;

import br.unifor.newsapi.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {
    @Query(value = "SELECT * FROM image", nativeQuery = true)
    List<Image> findAll();

    @Query(value = "select * from image where news_id = ?1", nativeQuery = true)
    List<Image> listNewImages(int input_id);
}
