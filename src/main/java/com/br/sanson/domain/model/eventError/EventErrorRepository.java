package com.br.sanson.domain.model.eventError;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by pc on 05/02/2017.
 */
@RepositoryRestResource(collectionResourceRel = "eventError",path = "eventError")
public interface EventErrorRepository  extends MongoRepository<EventError,String>{
}
