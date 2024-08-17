package com.example.demo.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Order(UUID uuid, Instant createdAt, List<Product> products) {
}
