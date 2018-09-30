package com.cybercom.fruitstore.dao;

import com.cybercom.fruitstore.data.persistent.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
