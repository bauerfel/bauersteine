package ch.zhaw.bauersteine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.bauersteine.model.User;

public interface UserRepository extends MongoRepository<User, String>{

 User findFirstByEmail(String email);
    
}
