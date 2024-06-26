package ch.zhaw.bauersteine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.bauersteine.model.Urne;
import ch.zhaw.bauersteine.model.UrneStateAggregation;

public interface UrneRepository extends MongoRepository<Urne, String>{
    List<Urne> findByInhaltsmenge(double inhaltsmenge);
    Urne findFirstById(String id);

    @Aggregation("{$group:{_id:'$state',urneIds:{'$push':'$_id',},count:{$count:{}}}}")  // todo: aggregation Pipeline anpassen Ids = Null
    //@Aggregation("{'$group':{'_id': '$state','UrneIds': {'$push': '$_id'},'count': {'$count': {}}}}")
   //@Aggregation("{'$group':{'_id':'$state','UrneIds':{'$addToSet':'$_id'},'count':{'$sum':1}}}")

    List<UrneStateAggregation> getUrneStateAggregation();
}
