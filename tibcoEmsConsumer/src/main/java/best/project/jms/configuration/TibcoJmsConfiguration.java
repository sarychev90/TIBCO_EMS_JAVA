package best.project.jms.configuration;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import com.tibco.tibjms.TibjmsConnectionFactory;

@Configuration
@EnableJms
public class TibcoJmsConfiguration {
	
	@Value("${tibco.ems.user}")
	private String user;
	
	@Value("${tibco.ems.password}")
	private String password;

	@Value("${tibco.ems.server.host}")
	private String host;
	
	@Value("${tibco.ems.server.port}")
	private String port;

	@Value("${tibco.ems.queue}")
	private String queue;

	@Bean
	@Qualifier("tibcoJmsConnectionFactory")
	public ConnectionFactory jmsConnectionFactory() throws JMSException {
		final TibjmsConnectionFactory tibcoConnectionFactory = new TibjmsConnectionFactory();
		tibcoConnectionFactory.setServerUrl("tcp://" + host + ":" + port);
		tibcoConnectionFactory.setUserName(user);
		tibcoConnectionFactory.setUserPassword(password);
		return tibcoConnectionFactory;
	}

	@Bean
	@Qualifier("tibcoJmsTemplate")
	public JmsTemplate jmsTemplate(@Autowired ConnectionFactory tibcoJmsConnectionFactory) {
		final JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(tibcoJmsConnectionFactory);
		jmsTemplate.setDefaultDestinationName(queue);
		jmsTemplate.setExplicitQosEnabled(true);
		jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
		jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		jmsTemplate.setSessionTransacted(false);
		return jmsTemplate;
	}
}
