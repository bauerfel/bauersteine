package ch.zhaw.bauersteine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.bauersteine.model.Urne;

public interface UrneRepository extends MongoRepository<Urne, String>{
    
}
