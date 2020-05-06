package com.mitesh.junit.JUnitSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitesh.junit.JUnitSpringBoot.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	
	
}
