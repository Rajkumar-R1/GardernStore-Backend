package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Product;
import com.example.springboot.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addBooking(@RequestBody Product booking) {
        Product newBooking = productService.create(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllBookings() {
        List<Product> bookings = productService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getBookingById(@PathVariable("id") int id) {
        Product booking = productService.getBookingById(id).orElse(null);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateBooking(@PathVariable("id") int id, @RequestBody Product booking) {
        if (productService.updateBooking(id, booking)) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBooking(@PathVariable("id") int id) {
        if (productService.deleteBooking(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Product>> getAllBookingsSorted(@RequestParam String sortBy) {
        List<Product> bookings = productService.getAllBookingsSortedBy(sortBy);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getAllBookingsPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Product> bookingsPage = productService.getAllBookingsPaginated(pageNo, pageSize);
        return new ResponseEntity<>(bookingsPage, HttpStatus.OK);
    }
}
