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

    public void save(ProductBean productBean) {
        String sqlQuery = "INSERT into products(name, cost) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(sqlQuery,
                productBean.getProductName(),
                productBean.getProductCost());
    }

    public void update(ProductBean productBean) {
        String sqlQuery = "update products set " +
                "name = ?, cost = ? " +
                "where id = ?";
        jdbcTemplate.update(sqlQuery
                , productBean.getProductName()
                , productBean.getProductCost()
                , productBean.getProductId());
    }
    public int delete(int id) {
        String sqlQuery = "delete from products " +
                "where id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sqlQuery, args);
    }

}
