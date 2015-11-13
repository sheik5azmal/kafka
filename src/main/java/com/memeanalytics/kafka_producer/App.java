package com.memeanalytics.kafka_producer;

import java.util.Properties;
import java.util.*;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Properties props=new Properties();
        Random r1 = new Random();
        props.put("metadata.broker.list", "ems.winext.com:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");
        
        ProducerConfig config=new ProducerConfig(props);
        Producer<String, String> kafkaProducer=new Producer<String, String>(config);
        
        for(int i=0; i < 500; ++i){
          
         int number1 = r1.nextInt(50);
        	KeyedMessage<String, String> data=new KeyedMessage<String, String>("test-topic", ""+number1);
        	kafkaProducer.send(data);
        
        System.out.println("DEVICE ID:" +number1);
        }
        kafkaProducer.close();
    }
}
