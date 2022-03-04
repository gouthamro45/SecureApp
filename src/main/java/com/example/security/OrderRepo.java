package com.example.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.security.models.Orders;

@RepositoryRestResource(collectionResourceRel = "Orders", path="Orders")
public interface OrderRepo extends JpaRepository<Orders, Integer>{

	
	@Query("SELECT SUM(c.price) FROM Orders c where c.id=?1")
	int checkOut(int id);
	
	@Query("from Orders o where o.id=?1")
	List<Orders> orderedItems(int uid);
}
