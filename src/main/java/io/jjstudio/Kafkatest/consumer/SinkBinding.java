package io.jjstudio.Kafkatest.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface SinkBinding {

    String INPUT = "input";

    @Input(SinkBinding.INPUT)
    SubscribableChannel inputChannel();
}
