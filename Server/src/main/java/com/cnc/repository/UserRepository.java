package com.cnc.repository;

import com.cnc.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Joe on 2015/12/26.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
