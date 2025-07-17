package com.solera.bootcamp.springbootdemo.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    // Additional query methods can be defined here if needed
    
}
