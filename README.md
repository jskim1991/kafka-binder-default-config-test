
# How to start and test
1. Start Zookeeper
2. Start Kafka
3. Produce an event to the topic named 'test-topic'
4. Let @StreamListener do the work (it will result in CommitFailedException, so it will retry)
5. On the console, look for 'log this message'. There will be more than 10 tries.

# How to send data via kafka producer via REST API
1. Open Chrome and go to http://localhost:8080/swagger-ui.html
2. Browse into kafka-controller
3. Click kafka-test/send API
4. Enter body
5. Click Execute
* you can use kafka-console-producer
./kafka-console-producer.sh --broker-list localhost:9092 --topic test-topic





