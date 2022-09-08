package best.project.jms.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import best.project.jms.model.Notification;

@Service
public class JmsNotificationPullReceiver implements NotificationReceiver {
	
	private JmsTemplate jms;

	public JmsNotificationPullReceiver(JmsTemplate jms) {
		this.jms = jms;
	}

	@Override
	public Notification receiveNotification() {
		return (Notification) jms.receiveAndConvert();
	}

}
