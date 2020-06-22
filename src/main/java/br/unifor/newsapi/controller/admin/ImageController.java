package br.unifor.newsapi.controller.admin;

import br.unifor.newsapi.model.Image;
import br.unifor.newsapi.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // CREATE - POST http://localhost:8081/admin/image
    @PostMapping
    public ResponseEntity<Image> add(@RequestBody Image body) {
        try {
            var image = imageService.save(body);
            return ResponseEntity.status(201).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
}
