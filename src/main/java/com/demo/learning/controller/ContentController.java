package com.demo.learning.controller;

import com.demo.learning.model.Content;
import com.demo.learning.model.Status;
import com.demo.learning.repository.ContentCollectionRepository;
import com.demo.learning.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    //private final ContentCollectionRepository contentCollectionRepository;
    private final ContentRepository contentCollectionRepository;
    @Autowired // it's the same thing if we have only one consturctor, add this annotation when we have multiple constructors
    public ContentController(ContentRepository contentCollectionRepository){
        this.contentCollectionRepository = contentCollectionRepository;
    }
    @GetMapping("") /// means path is /api/content
    public List<Content> findAll(){
        return contentCollectionRepository.findAll();
    }
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){ // path variable is used to retrieve the id in the endpoint
        return contentCollectionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){ // bind content to the request body of the post request
        // valid is for triggering validation for content NotBlank
        contentCollectionRepository.save(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!contentCollectionRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!");// better create ContentNotFound exception
        }
        contentCollectionRepository.save(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(!contentCollectionRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!");// better create ContentNotFound exception
        }
        contentCollectionRepository.deleteById(id);
    }
    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return contentCollectionRepository.findAllByTitleContains(keyword);
    }
    @GetMapping("/filter/status/{status}")
    public List<Content> findbyStatus(@PathVariable Status status){
        return contentCollectionRepository.listByStatus(status);
    }

}
