package io.jjstudio.Kafkatest.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SourceBinding {

    String OUTPUT = "output";

    @Output(SourceBinding.OUTPUT)
    MessageChannel outputChannel();
}
