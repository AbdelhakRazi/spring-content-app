package com.demo.learning.repository;

import com.demo.learning.model.Content;
import com.demo.learning.model.Status;
import com.demo.learning.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentJdbcTemplateRepository{
    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Content(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getTimestamp("date_created").toLocalDateTime(),
                rs.getTimestamp("date_updated").toLocalDateTime(),
                rs.getString("url"));
    }
    public List<Content> findAll() {
        String sqlQuery = "SELECT * FROM Content";
        return
                 jdbcTemplate.query(sqlQuery, ContentJdbcTemplateRepository::mapRow);
    }

    public Optional<Content> findById(Integer id) {
        return Optional.empty();
    }

    public void save(Content content) {

    }

    public boolean existsById(int id) {
        return false;
    }

    public void delete(int id) {

    }
}
