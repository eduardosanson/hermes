package com.br.sanson.aplication.repository;

import com.br.sanson.aplication.config.MessageConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pc on 04/02/2017.
 */
public interface MessagingRepository extends MongoRepository<MessageConfig,String> {

    MessageConfig findByEventTypeAndTenant(String evenType,String tenant);
}
