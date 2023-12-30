package com.demo.learning.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
// we could say that this is @Table(value="table_content")
public record Content(
        @Id
        Integer id,
                      @NotBlank // we can use NotEmpty as well, should dig into constraints folder to find out about everything
                      String title,
                      String description,
                      Status status,
                      Type contentType,
                      LocalDateTime dateCreated,
                      LocalDateTime dateUpdated,
                      String url) {

}
