package vn.techmaster.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
