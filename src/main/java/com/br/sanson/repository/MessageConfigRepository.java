package com.br.sanson.repository;

import com.br.sanson.domain.config.MessageConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pc on 04/02/2017.
 */
public interface MessageConfigRepository extends MongoRepository<MessageConfig,String> {

    MessageConfig findByEventTypeAndTenant(String evenType,String tenant);
}
