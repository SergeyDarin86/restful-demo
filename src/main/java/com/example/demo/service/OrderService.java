package com.example.demo.service;

import com.example.demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {
    private final HashMap<UUID, Order> orders = new HashMap<>();

    /**
     * @param uuid идентификатор заказа
     * @return заказ
     *
     * Поиск заказа по уникальному идентификатору
     */

    public Order findByUuid(UUID uuid){
        return findOrderByUuid(uuid);
    }

    /**
     * @return список всех хранимых заказов
     */
    @Scheduled(cron = "${cron.delayedInfo}")
    public Collection<Order> getAll(){
        log.info("OrderService: getAll " + ZonedDateTime.now() + " Start method");
        log.error("OrderService: getAll " + ZonedDateTime.now() + " Start method");
        log.warn("OrderService: save() " + ZonedDateTime.now() + " Start method");
        return orders.values();
    }

    /**
     * @param order новый заказ
     *
     * Создание и запись нового заказа
     */

    public void save(Order order){
        var uuid = UUID.randomUUID();
        var newOrder = new Order(uuid, order.createdAt(), order.products());
        orders.put(newOrder.uuid(),newOrder);
    }

    /**
     * @param uuid идентификатор заказа для обновления
     * @param order полные данные для обновления заказа
     *
     * Обновление всех полей заказа
     */

    public void update(UUID uuid, Order order){
        var currentOrder = findOrderByUuid(uuid);
        var updatedOrder = new Order(currentOrder.uuid(), order.createdAt(), order.products());
        orders.put(currentOrder.uuid(),updatedOrder);
    }

    /**
     * @param uuid идентификатор заказа для удаления
     *
     * Удаление заказа
     */

    public void delete(UUID uuid){
        var currentOrder = findOrderByUuid(uuid);
        orders.remove(currentOrder.uuid());
    }

    /**
     * @param order заказ с полями для обновления
     * Частичное обновление заказа, обновляются только
     * те поля, которые не равны null
     */

    public void partUpdate(UUID uuid, Order order){
        var currentOrder = findOrderByUuid(uuid);
        if (order.createdAt() != null){
            currentOrder = new Order(currentOrder.uuid(), order.createdAt(), currentOrder.products());
        }
        if (order.products() != null){
            currentOrder = new Order(currentOrder.uuid(), currentOrder.createdAt(), order.products());
        }
        orders.put(currentOrder.uuid(), currentOrder);
    }

    private Order findOrderByUuid(UUID uuid){
        var order = orders.get(uuid);
        if (order == null){
            throw new RuntimeException("Order has not found");
//            throw new OrderNotFoundException();
        }
        return order;
    }

//    @Scheduled(cron = "${cron.delayedInfo}")
//    public void delayed() {
//        log.info("OrderService: delayedInfo " + ZonedDateTime.now() + " Start method");
//    }
//
//    @Scheduled(cron = "${cron.delayedWarn}")
//    public void delayedWarn() {
//        log.warn("OrderService: delayedWarn " + ZonedDateTime.now() + " Start method");
//    }


}
