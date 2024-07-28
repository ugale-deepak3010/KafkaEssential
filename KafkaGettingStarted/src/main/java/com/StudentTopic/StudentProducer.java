package com.StudentTopic;

import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

/*
CREATING TOPIC

find the list of topics:
 
 ./kafka-topics.sh \ 
 			--bootstrap-server localhost:29092 \ 
 			--describe
 
if not created then create it.
  
 ./kafka-topics.sh \ 
 			--bootstrap-server localhost:29092 \ 
 			--create \ 
 			--topic kafka.student.topic \ 
 			--partitions 1 \ 
 			--replication-factor 1
 			
 consume message
 
  ./kafka-console-consumer.sh \
            --bootstrap-server localhost:29092 \
            --topic kafka.student.topic \
            --from-beginning
  
 */

public class StudentProducer {

	public static void main(String[] args) {

		System.out.println("Starting....");

		System.out.println("setting basic properties for broker...");

		Properties properties = new Properties();

		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");


		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");

		System.out.println("creating producer");

		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

		ProducerRecord<String, String> producerRecord0 = new ProducerRecord<String, String>("kafka.student.topic",
				"timeNow:" + LocalDateTime.now().toString());

		ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("kafka.student.topic",
				"name:deepak");
		ProducerRecord<String, String> producerRecord2 = new ProducerRecord<String, String>("kafka.student.topic",
				"dept:dev");

		System.out.println("Sending data...");

		kafkaProducer.send(producerRecord0);
		kafkaProducer.send(producerRecord);
		kafkaProducer.send(producerRecord2);
		kafkaProducer.send(new ProducerRecord<String, String>("kafka.student.topic", "salary:99999999"));

		System.out.println("Data sending done. closing the app");
		kafkaProducer.close();

	}

}
