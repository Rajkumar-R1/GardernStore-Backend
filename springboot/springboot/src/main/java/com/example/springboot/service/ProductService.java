package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.springboot.model.Product;
import com.example.springboot.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo ProductRepository;

    public Product create(Product booking) {
        return ProductRepository.save(booking);
    }

    public List<Product> getAllBookings() {
        return ProductRepository.findAll();
    }

    public Optional<Product> getBookingById(int id) {
        return  ProductRepository.findById(id);
    }

    public boolean updateBooking(int id, Product booking) {
        if (!ProductRepository.existsById(id)) {
            return false;
        }
        booking.setId(id);
        ProductRepository.save(booking);
        return true;
    }

    public boolean deleteBooking(int id) {
        if (!ProductRepository.existsById(id)) {
            return false;
        }
        ProductRepository.deleteById(id);
        return true;
    }

    public List<Product> getAllBookingsSortedBy(String sortBy) {
        return ProductRepository.findAll(Sort.by(sortBy));
    }

    public Page<Product> getAllBookingsPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return ProductRepository.findAll(pageable);
    }
}
