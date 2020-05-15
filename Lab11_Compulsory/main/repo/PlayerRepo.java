package main.repo;

import main.entity.Players;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PlayerRepo interface helps communication with the database
 */
@Repository
public interface PlayerRepo extends CrudRepository<Players, Integer> {

}