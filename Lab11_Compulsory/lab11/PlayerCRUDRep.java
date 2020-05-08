package com.example.lab11;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PlayerCRUDRep interface helps communication with the database
 */
@Repository
public interface PlayerCRUDRep extends CrudRepository<Players, Integer> {

}