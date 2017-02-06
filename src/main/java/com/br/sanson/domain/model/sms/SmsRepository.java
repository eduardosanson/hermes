package com.br.sanson.domain.model.sms;

import com.br.sanson.domain.model.sms.Sms;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pc on 04/02/2017.
 */
public interface SmsRepository extends MongoRepository<Sms,String> {
}
