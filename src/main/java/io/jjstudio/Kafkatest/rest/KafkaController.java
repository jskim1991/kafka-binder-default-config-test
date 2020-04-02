package io.jjstudio.Kafkatest.rest;

import io.jjstudio.Kafkatest.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka-test")
public class KafkaController {

    @Autowired
    KafkaProducer producer;

    @PostMapping("send")
    public void send(@RequestBody String body) {
        producer.send(body);
    }
}
