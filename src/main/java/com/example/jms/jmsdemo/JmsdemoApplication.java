package com.example.jms.jmsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

@SpringBootApplication
@EnableJms
public class JmsdemoApplication {

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
													DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}


	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JmsdemoApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		System.out.println("Sending a String JMS message.");
		jmsTemplate.convertAndSend("sampleQueue", "Hello world!");

		UserDetails details = new UserDetails( "John", "Doe", "1234567788", "12 Reston Street");

        System.out.println("Sending an object JMS message.");
		//jmsTemplate.convertAndSend("NewSampleQueue", details);

        jmsTemplate.send("NewSampleQueue", new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException{
                ObjectMessage objectMessage = session.createObjectMessage(details);
                return objectMessage;
            }
        });
	}
}
