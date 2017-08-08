package com.luoyu.yorozuya.repository;

import com.luoyu.yorozuya.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll(Specification<User> personSpecification, Pageable pageable);
}
