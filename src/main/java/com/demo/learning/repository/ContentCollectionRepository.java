package com.demo.learning.repository;

import com.demo.learning.model.Content;
import com.demo.learning.model.Status;
import com.demo.learning.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository{
    private final List<Content> contentList = new ArrayList<>();
    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(content1 -> content1.id().equals(id)).findFirst();
    }
    @PostConstruct // this method is executed after dependecy injection is performed
    private void init(){
        Content c = new Content(1,
                "first blog post",
                "description", Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(c);
    }
    public void save(Content content){
        contentList.removeIf(content1 -> content1.id().equals(content.id()));
        contentList.add(content);
    }
    public boolean existsById(int id){
        return contentList.stream().filter(content -> content.id().equals(id)).count()==1;
    }
    public void delete(int id){
        contentList.removeIf(content -> content.id().equals(id));
    }

}
