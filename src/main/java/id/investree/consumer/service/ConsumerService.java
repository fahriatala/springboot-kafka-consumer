package id.investree.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.investree.consumer.model.ConsumerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class ConsumerService {

	private KafkaTemplate<String, ConsumerModel> kafkaTemplate;
	private CountDownLatch latch;

	@Autowired
	public ConsumerService(KafkaTemplate<String, ConsumerModel>  kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@KafkaListener(topics = "myTopic", containerFactory = "kafkaListenerContainerFactory")
	public void getFromKafka(String message) throws JsonProcessingException, InterruptedException {
		ObjectMapper mapper = new ObjectMapper();
		ConsumerModel consumerModel = mapper.readValue(message, ConsumerModel.class);
		System.out.println("consumerModel = " + consumerModel);
		System.out.println("consumer.getId() = " + consumerModel.getField1());
		System.out.println("consumed message: " + message);
		Thread.sleep(1000);
		latch.await();
	}
}
