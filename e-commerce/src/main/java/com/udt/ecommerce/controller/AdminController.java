package com.udt.ecommerce.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @PostMapping(value = "/product")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> createProduct(@RequestBody String product) {
        //TODO implement method
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<?> getUserInfo(@RequestParam String userId) {
        //TODO implement method
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
