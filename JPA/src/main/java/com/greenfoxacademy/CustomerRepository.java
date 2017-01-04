package com.greenfoxacademy;

/**
 * Created by posam on 2016-12-22.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}