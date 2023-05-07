package com.smpark.springexample.repository;

import com.smpark.springexample.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findAll();
    Users findUsersById(Long id);

    void deleteById(Long id);

}
