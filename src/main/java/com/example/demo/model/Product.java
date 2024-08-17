package com.example.demo.model;

import java.math.BigDecimal;

public record Product(String name, BigDecimal price, Integer count) {
}
