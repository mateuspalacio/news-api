package br.unifor.newsapi.model;

import br.unifor.newsapi.model.Category;
import br.unifor.newsapi.model.Image;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="news")
@RedisHash("news")
public class News implements Serializable {
    @Id // Primary Key
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Category category;


    public News(){

    }
    public News( String text, String title, int category_id) { //

        this.text = text;
        this.title = title;
        this.category.setId(category_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
