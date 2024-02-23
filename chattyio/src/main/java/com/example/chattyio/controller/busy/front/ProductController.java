package com.example.chattyio.controller.busy.front;

import com.example.chattyio.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/busy/front")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/nocache")
    public ResponseEntity<String> getProductsNoCache() {
        try {
            StopWatch sw = new StopWatch();
            sw.start();
            String result = productService.getProductsWithoutCaching();
            sw.stop();
            log.info("getProductsNoCache time process mili: {}", sw.getTotalTimeMillis());
            log.info("getProductsNoCache time process nano: {}", sw.getTotalTimeNanos());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/cache")
    public ResponseEntity<String> getProductsCache() {
        try {
            StopWatch sw = new StopWatch();
            sw.start();
            String result = productService.getProductsWithCaching();
            sw.stop();
            log.info("getProductsCache time process mili: {}", sw.getTotalTimeMillis());
            log.info("getProductsCache time process nano: {}", sw.getTotalTimeNanos());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
