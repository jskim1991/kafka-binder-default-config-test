package io.jjstudio.Kafkatest.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

@EnableBinding(SinkBinding.class)
public class KafkaConsumer {

    @StreamListener(value = SinkBinding.INPUT)
    public void listen(Message<String> message) throws InterruptedException {
        System.out.println("log this message : " + message.getPayload());
        try {
            // do something
            sendAck(message);
        }
        catch (Exception e) {
            throw e; // retry
        }
    }

    public void sendAck(Message<String> message) {
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            try {
                acknowledgment.acknowledge();
                System.out.println("manual commit complete");
            }
            catch (Exception e) {
                throw e; // retry
            }
        }
    }
}
