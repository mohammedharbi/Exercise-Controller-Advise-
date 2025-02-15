package com.example.autowash.Controller;

import com.example.autowash.Model.OrderAutoWashCar;
import com.example.autowash.Service.OrderAutoWashCarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order-auto-wash-car")
@RequiredArgsConstructor
public class OrderAutoWashCarController {
    private final OrderAutoWashCarService orderAutoWashCarService;

    @GetMapping("/get")
    public ResponseEntity getOrderAutoWashCar() {
        return ResponseEntity.status(200).body(orderAutoWashCarService.getOrderAutoWashCar());
    }

    @PostMapping("/add")
    public ResponseEntity addOrderAutoWashCar(@RequestBody @Valid OrderAutoWashCar orderAutoWashCar) {
        return ResponseEntity.status(201).body(orderAutoWashCarService.addOrderAutoWashCar(orderAutoWashCar));
    }

    // No need for this endpoint it will call it self every 10 seconds in the service layer by using @@Scheduled
//    @PutMapping("/updateOrderStatus")
//    public ResponseEntity updateOrderStatus() {
//        orderAutoWashCarService.updateOrderStatus();
//        return ResponseEntity.status(200).body("Order auto wash car status updated");
//    }

    @GetMapping("/user-order-auto-wash-car-history/{userId}")
    public ResponseEntity getOrderAutoWashCarHistory(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(orderAutoWashCarService.userOrderAutoWashCarHistory(userId));
    }

    @PutMapping("/user-order-cancellation/user/{userId}/order/{orderId}")
    public ResponseEntity userOrderCancellation(@PathVariable Integer userId, @PathVariable Integer orderId) {
        orderAutoWashCarService.orderCancellation(userId, orderId);
        return ResponseEntity.status(200).body("auto wash car Order canceled");
    }
}
