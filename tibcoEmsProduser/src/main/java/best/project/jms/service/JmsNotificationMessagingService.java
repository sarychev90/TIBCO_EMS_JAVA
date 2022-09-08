package best.project.jms.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import best.project.jms.model.Notification;

@Service
public class JmsNotificationMessagingService implements NotificationMessagingService {
	
	private static final Logger LOG = Logger.getLogger(JmsNotificationMessagingService.class.getName());
	
	@Autowired
	@Qualifier("tibcoJmsTemplate")
	private JmsTemplate jms;

	@Override
	public void sendNotification(Notification notification) {
		LOG.log(Level.INFO, "sending notification: {0}", notification.toString());
		jms.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(notification);
			}
		});
	}

}
