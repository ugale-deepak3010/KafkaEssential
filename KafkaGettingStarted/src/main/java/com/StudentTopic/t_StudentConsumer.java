package com.StudentTopic;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


public class t_StudentConsumer {

	public static void main(String[] args) {
		
		Properties properties= new Properties();
		
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "kafka-java-student-consumer");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		KafkaConsumer<String, String> kafkaConsumer= new KafkaConsumer<String, String>(properties);
		
		kafkaConsumer.subscribe(Arrays.asList("kafka.student.topic"));
		
		ConsumerRecords<String, String> consumerRecords= kafkaConsumer.poll(Duration.ofSeconds(2));
		
				
		for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
			System.out.println("record is= "+consumerRecord);
		}
		
		kafkaConsumer.close();
	}

}
