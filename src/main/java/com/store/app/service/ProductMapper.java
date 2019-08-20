package com.store.app.service;

import com.store.app.bean.ProductBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductBean> {
    @Override
    public ProductBean mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ProductBean(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("cost"));
    }
}
