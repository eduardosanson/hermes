package com.br.sanson.domain.model.sms;

import com.br.sanson.domain.model.sms.Sms;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by pc on 04/02/2017.
 */
@RepositoryRestResource(collectionResourceRel = "sms",path = "sms")
public interface SmsRepository extends MongoRepository<Sms,String> {
}
