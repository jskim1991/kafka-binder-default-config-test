package io.jjstudio.Kafkatest.config;

import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.*;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfiguration {

    @Bean
    public ListenerContainerCustomizer<AbstractMessageListenerContainer<?, ?>> cust() {
        return (container, destination, group) -> {
//            container.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
            container.setErrorHandler(new SeekToCurrentErrorHandler((record, exception) -> {}
                , new FixedBackOff(0L, 0L)));
        };

    }
}
