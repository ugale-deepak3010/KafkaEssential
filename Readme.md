Kafka Practices Project.

Used Java Technologies!

system static file path: 
C:\Users\ugale\Desktop\Notes\Kafka\KafkaEssential\kafka-single-node.yml











---------------------------------------------------------------------------------------------
		KAFKA WORKSPACE MY NOTES


**********************************************************************************************
		1:	[INTRODUCTION OF KAFKA]
		
using docker kafka
		
Step1: open the cmd where kafka-single-node.yml is present

>docker-compose -f kafka-single-node.yml up -d

// docker will up


Broker is a Kafka instance

step2: enter in docker kafka

>docker exec -it kafka-broker /bin/bash

any configuration canges required to restart kafka

installation path: cd opt/bitnami/kafka/

		3:	[KAFKA CMD]

refer chapter-3-commands.txt

step 1:

create topic 1



> ./kafka-topics.sh \
            --bootstrap-server localhost:29092 \
            --create \
            --topic kafka.learning.tweets \
            --partitions 1 \
            --replication-factor 1
            
            
create topic 2

>./kafka-topics.sh \
            --bootstrap-server localhost:29092 \
            --create \
            --topic kafka.learning.alerts \
            --partitions 1 \
            --replication-factor 1


get list of topics:

>./kafka-topics.sh \
            --bootstrap-server localhost:29092 \
            --list


output will be:

kafka.learning.alerts

kafka.learning.tweets



Multiple producer can send to multiple consumers for single topic.






















































