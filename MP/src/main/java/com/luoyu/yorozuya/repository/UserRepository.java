package com.luoyu.yorozuya.repository;

import com.luoyu.yorozuya.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
    @Query("select u from User u where u.name like ?1 and u.password like ?2")
    User findauser(String name, String password);

    User findByNameAndPassword(String name, String password);

    @Modifying
    @Transactional
    int deleteById(Long id);

    @Modifying
    @Transactional
    @Query("delete from User u where u.id = :id")
    int deleteUser(@Param("id") Integer id);
}
