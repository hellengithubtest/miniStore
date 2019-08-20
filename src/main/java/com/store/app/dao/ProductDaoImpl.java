package com.store.app.dao;

import com.store.app.bean.ProductBean;
import com.store.app.service.ProductMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    public final JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<ProductBean> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public ProductBean findById(int id) {
        String sql = "SELECT id, name, cost FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},
                new ProductMapper());
    }
}
