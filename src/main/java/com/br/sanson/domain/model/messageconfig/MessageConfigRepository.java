package com.br.sanson.domain.model.messageconfig;

import com.br.sanson.domain.shared.enums.EventType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * Created by pc on 04/02/2017.
 */
@RepositoryRestResource(collectionResourceRel = "MessageConfig")
public interface MessageConfigRepository extends MongoRepository<MessageConfig,String> {

    Optional<MessageConfig> findByEventTypeAndTenant(@Param("eventType") EventType evenType, @Param("tenant") String tenant);
}
