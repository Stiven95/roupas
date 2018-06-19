package br.com.fiap.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqFactoryConfig {

	@Value("${jsa.activemq.broker.url}")
	String brokerUrl;
	
	@Value("${jsa.activemq.borker.username}")
	String userName;
	
	@Value("${jsa.activemq.borker.password}")
	String userPass;
	
	/**
	 * Connection
	 * @return
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerUrl);
		connectionFactory.setUserName(userName);
		connectionFactory.setPassword(userPass);
		return connectionFactory;
	}
	
	/**
	 * Receiving Message
	 * @param connectionFactory
	 * @param configurer
	 * @return
	 */
	@Bean
	public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
	}
	
	/**
	 * Sending Message
	 * @return
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		return template;
	}
}
