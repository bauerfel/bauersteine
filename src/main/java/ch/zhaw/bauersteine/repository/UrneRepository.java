package ch.zhaw.bauersteine.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.bauersteine.model.Urne;

public interface UrneRepository extends MongoRepository<Urne, String>{
    List<Urne> findByInhaltsmenge(double inhaltsmenge);
}
