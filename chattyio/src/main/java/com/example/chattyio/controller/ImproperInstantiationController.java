package com.example.chattyio.controller;

import com.example.chattyio.entity.Product;
import com.example.chattyio.improper.DataDriverManager;
import com.example.chattyio.improper.SingletonDataDriverManager;
import com.example.chattyio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
@RequestMapping("/api/instantiation")
public class ImproperInstantiationController {

    @Autowired
    ProductService productService;

    @GetMapping("/proper")
    public ResponseEntity<String> singleton() {
        try {

            Product product = productService.getProduct(1);
            return new ResponseEntity<>(product.toString(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/improper")
    public ResponseEntity<String> improper() {
        try {

            String sql = "SELECT * FROM product WHERE id = ?";
            Product product = null;
            Connection connection = new DataDriverManager().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                product = new Product(id, name);
            }
            connection.close();
            return new ResponseEntity<>(product.toString(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
