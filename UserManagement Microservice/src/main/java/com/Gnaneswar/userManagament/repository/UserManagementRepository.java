package com.Gnaneswar.userManagament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gnaneswar.userManagament.model.User;

@Repository
public interface UserManagementRepository extends JpaRepository<User, Integer> {

}
