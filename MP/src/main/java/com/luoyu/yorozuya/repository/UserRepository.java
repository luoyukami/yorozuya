package com.luoyu.yorozuya.repository;

import com.luoyu.yorozuya.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);

    User findByUsername(@Param(value = "username") String username);

    @Query("select u from User u where u.username like ?1 and u.password like ?2")
    User findAUser(String username, String password);

    User findByUsernameAndPassword(String username, String password);

    @Modifying
    @Transactional
    int deleteById(Long id);

    @Modifying
    @Transactional
    @Query("delete from User u where u.id = :id")
    int deleteUser(@Param("id") Integer id);
}
