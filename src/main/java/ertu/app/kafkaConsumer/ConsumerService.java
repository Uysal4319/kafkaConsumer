package ertu.app.kafkaConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	@Autowired
	public EmployeeRepository repository;
	
	@KafkaListener(topics = "topic10",containerFactory = "kafkaListenerContainerFactory")
	public void consume(Employee employee){
		
		System.out.println("Coming : " + employee.toString());
		repository.save(employee);
		System.out.println("saved mongodb");
	}
	
}
