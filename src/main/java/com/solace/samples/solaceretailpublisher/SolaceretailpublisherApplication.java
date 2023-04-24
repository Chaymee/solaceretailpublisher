package com.solace.samples.solaceretailpublisher;

import com.solacesystems.jcsmp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import com.solace.samples.solaceretailpublisher.GenerateOrder;
import com.solace.samples.solaceretailpublisher.AvroSerializer;

@SpringBootApplication
public class SolaceretailpublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolaceretailpublisherApplication.class, args);
	}

	@Component
	static class Runner implements CommandLineRunner {
		private static final Logger logger = LoggerFactory.getLogger(Runner.class);

		//private final Topic topic = JCSMPFactory.onlyInstance().createTopic("solace.sample.retail.store.new.order");
		//private final Topic topic = JCSMPFactory.onlyInstance().createTopic("inbound/for/snowflake/text");

		@Autowired
		private SpringJCSMPFactory solaceFactory;

		private DemoPublishEventHandler pubEventHandler = new DemoPublishEventHandler();

		public void run(String... strings) throws Exception {
			final JCSMPSession session = solaceFactory.createSession();

			/** Anonymous inner-class for handling publishing events */
			XMLMessageProducer prod = session.getMessageProducer(pubEventHandler);
			// Publish-only session is now hooked up and running!

			AvroSerializer serializer = new AvroSerializer();
			boolean stop = false;
			while (stop != true) {
				GenerateOrder order = new GenerateOrder();
				BytesMessage jcsmpMsg = JCSMPFactory.onlyInstance().createMessage(BytesMessage.class);
				jcsmpMsg.setData(serializer.serializeAvroOrderJSON(order.getOrder()));
				jcsmpMsg.setDeliveryMode(DeliveryMode.PERSISTENT);
				Topic topic = JCSMPFactory.onlyInstance().createTopic("retail/pos/" + order.getOrder().getStore().toLowerCase().replaceAll(" ", "_") + "/" + order.getOrder().getStoreSize());
				logger.info("============= Sending " + order.getOrder());
				logger.info("Over topic" + topic);
				prod.send(jcsmpMsg, topic);
				Thread.sleep(5000);
			}


		}
	}
}
