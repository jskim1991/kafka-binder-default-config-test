package io.jjstudio.Kafkatest.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(SourceBinding.class)
public class KafkaProducer {

    @Autowired
    SourceBinding binding;

    public void send(String payload) {
        binding.outputChannel().send(
                MessageBuilder.withPayload(payload).build()
        );
    }
}
