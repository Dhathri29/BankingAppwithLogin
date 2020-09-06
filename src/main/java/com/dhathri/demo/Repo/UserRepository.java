package com.dhathri.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dhathri.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

}