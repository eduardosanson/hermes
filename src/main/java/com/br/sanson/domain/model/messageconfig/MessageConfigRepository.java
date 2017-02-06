package com.br.sanson.domain.model.messageconfig;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by pc on 04/02/2017.
 */
public interface MessageConfigRepository extends MongoRepository<MessageConfig,String> {

    Optional<MessageConfig> findByEventTypeAndTenant(String evenType, String tenant);
}
