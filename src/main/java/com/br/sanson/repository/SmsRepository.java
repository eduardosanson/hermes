package com.br.sanson.repository;

import com.br.sanson.domain.Sms;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pc on 04/02/2017.
 */
public interface SmsRepository extends MongoRepository<Sms,String> {
}
