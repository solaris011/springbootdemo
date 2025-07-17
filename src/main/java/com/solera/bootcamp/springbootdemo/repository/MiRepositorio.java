package com.solera.bootcamp.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solera.bootcamp.springbootdemo.Models.Product;


@Repository
public interface MiRepositorio extends CrudRepository<Product, Long> {



}