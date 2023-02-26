package com.udt.ecommerce.repository;

import com.udt.ecommerce.dao.UserDAO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDAO, Integer> {
    UserDAO findByUsername(String userName);
}
