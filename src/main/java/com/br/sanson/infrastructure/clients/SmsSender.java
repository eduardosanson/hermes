package com.br.sanson.infrastructure.clients;

import com.br.sanson.domain.shared.Mensagem;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pc on 05/02/2017.
 */
@FeignClient(name = "sms",url = "${sms.url}",fallbackFactory = SmsFactory.class)
public interface SmsSender {

    @RequestMapping(method = RequestMethod.POST,
            value = "${sms.send}/{msisdn}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
//    public void sendSms(@PathVariable(value = "msisdn") String msisdn, Mensagem mensagem);
    public void sendSms(@RequestBody String mensagem, @PathVariable(value = "msisdn") String msisdn);
}
