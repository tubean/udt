package com.udt.ecommerce.repository;

import com.udt.ecommerce.dao.RoleDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleDAO, Integer> {
    RoleDAO findById(int roleId);
}
