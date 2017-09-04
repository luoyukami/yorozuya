package com.luoyu.yorozuya.repository;

import com.luoyu.yorozuya.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 落羽 on 2017/9/1.
 */
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(String roleName);
}
