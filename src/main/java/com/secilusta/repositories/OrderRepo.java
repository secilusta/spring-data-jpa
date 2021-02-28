package com.secilusta.repositories;

import com.secilusta.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Orders, Integer> {

}
