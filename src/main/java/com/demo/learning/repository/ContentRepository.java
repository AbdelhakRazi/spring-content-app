package com.demo.learning.repository;

import com.demo.learning.model.Content;
import com.demo.learning.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    //Query derivation automatically executed
    List<Content> findAllByTitleContains(String keyword);
    // Manually now
    @Query("""
       SELECT * FROM Content content
       WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
