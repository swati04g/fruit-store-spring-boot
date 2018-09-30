package com.cybercom.fruitstore.dao;

import com.cybercom.fruitstore.data.persistent.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
