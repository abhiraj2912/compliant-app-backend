package com.example.compliantappbackend.dao;

import com.example.compliantappbackend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {


    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `pincode`, `username` FROM `users` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<User>LoginCheck( @Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `pincode`, `username` FROM `users` WHERE `id`=:id", nativeQuery = true)
    List<User>UserInfo(@Param("id") Integer id);
}
