package com.dhathri.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dhathri.demo.model.Item;
import com.dhathri.demo.model.User;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	public Item findByUsernameAndPassword(String username, String password);	

		
}