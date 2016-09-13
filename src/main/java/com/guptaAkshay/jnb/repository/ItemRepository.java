package com.guptaAkshay.jnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guptaAkshay.jnb.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
