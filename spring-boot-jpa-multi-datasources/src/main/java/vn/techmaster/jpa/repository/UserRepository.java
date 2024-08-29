package vn.techmaster.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
