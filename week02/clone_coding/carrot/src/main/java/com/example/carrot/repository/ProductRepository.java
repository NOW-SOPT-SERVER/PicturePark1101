package com.example.carrot.repository;

import com.example.carrot.model.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT p FROM Product p WHERE p.region.name = :regionName")
  List<Product> findByRegionName(@Param("regionName") String regionName);

}
