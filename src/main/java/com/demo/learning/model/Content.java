package com.demo.learning.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Content(Integer id,
                      @NotBlank // we can use NotEmpty as well, should dig into constraints folder to find out about everything
                      String title,
                      String description,
                      Status status,
                      Type contentType,
                      LocalDateTime dateCreated,
                      LocalDateTime dateUpdated,
                      String url) {

}
