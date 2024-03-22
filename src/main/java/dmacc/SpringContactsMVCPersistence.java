package dmacc;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Address;
import dmacc.beans.Contact;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.ContactRepository;

@SpringBootApplication
public class SpringContactsMVCPersistence{

	public static void main(String[] args) {
		SpringApplication.run(SpringContactsMVCPersistence.class, args);

		@SuppressWarnings("resource")
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Contact c = appContext.getBean("contact", Contact.class); // type in "" tells which type of object to cast the bean to

		// after getting the bean, can use the class methods to get or set values
		System.out.println(c.toString());
	}
	
	@Autowired
	ContactRepository repo;

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//Using an existing bean
		Contact c = appContext.getBean("contact", Contact.class);
		c.setRelationship("best friend");
		repo.save(c);
		
		//Create a bean to use - not managed by Spring
		Contact d = new Contact("Sandra Boyton", "555-555-5556", "friend");
		Address a = new Address("123 Main Street", "Des Moines", "IA");
		d.setAddress(a);
		repo.save(d);
		//enhanced for loop to list all entries in database
		List<Contact> allMyContacts = repo.findAll();
		for(Contact people: allMyContacts) {
			System.out.println(people.toString());
		}
		
		//closes the ApplicationContext resource leak - not imperative to add but nice to clean it up
		((AbstractApplicationContext) appContext).close();
	
		
	}

	
	
	
	}

