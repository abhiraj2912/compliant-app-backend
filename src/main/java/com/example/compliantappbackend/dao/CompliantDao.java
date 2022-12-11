package com.example.compliantappbackend.dao;

import com.example.compliantappbackend.model.Compliant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CompliantDao extends CrudRepository<Compliant, Integer> {

    @Query(value = "SELECT `id`, `compliant`, `user_id` FROM `compliants` WHERE `user_id`= :userId ",nativeQuery = true)
    List<Compliant> UserView(@Param("userId") Integer userId);

    @Query(value = "SELECT u.`name`, u.`email`, u.`phone`, u.address, c.compliant FROM `users` u JOIN compliants c ON u.id=c.user_id",nativeQuery = true)
    List<Map<String,String>> AdminView();
}
