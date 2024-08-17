package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import com.example.demo.service.PostPersInfoImpl;
import com.example.demo.service.ResponseForSending;
//import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/orders")
//@RequestMapping("/api/indexPage")
//@Api("restfull controller")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Order> get(@PathVariable UUID uuid) {
        return ResponseEntity.ok(orderService.findByUuid(uuid));
    }

    @GetMapping("/")
    public ResponseEntity<Collection<Order>> getAll() {
        log.info("Method: getAll from controller");
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody Order order) {
        orderService.save(order);
        return ResponseEntity.ok().build();
    }

    @Autowired
    PostPersInfoImpl postPersInfo;

//    @PostMapping("/")
//    public ResponseEntity<ResponseForSending> send(@RequestParam String url) {
//        return ResponseEntity.ok(postPersInfo.getSendingPageResponse(url));
//    }


    @PutMapping("/{uuid}")
    public ResponseEntity<Void> update(@PathVariable UUID uuid, @RequestBody Order order) {
        orderService.update(uuid, order);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<Void> patch(@PathVariable UUID uuid, @RequestBody Order order) {
        orderService.partUpdate(uuid, order);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        orderService.delete(uuid);
        return ResponseEntity.ok().build();
    }


}

