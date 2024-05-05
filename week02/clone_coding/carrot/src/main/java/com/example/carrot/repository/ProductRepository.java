package com.example.carrot.repository;

import com.example.carrot.model.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByRegionId(Long regionId);

}
