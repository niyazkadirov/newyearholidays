/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newyearhollidays.AMQ;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import javax.jms.*;



public class Consumer extends Thread {

    public static final Logger LOG = Logger.getLogger(Consumer.class.getName());
    // URL of the JMS server
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // Name of the queue we will receive messages from
    private static String subject = "TESTQUEUE";

    @Override
    public void run() {
        while (true) {
            try {
                // Getting JMS connection from the server
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
                Connection connection = connectionFactory.createConnection();
                connection.start();

                // Creating session for sending messages
                Session session = connection.createSession(false,
                        Session.AUTO_ACKNOWLEDGE);

                // Getting the queue 'TESTQUEUE'
                Destination destination = session.createQueue(subject);

                // MessageConsumer is used for receiving (consuming) messages
                MessageConsumer consumer = session.createConsumer(destination);

                // Here we receive the message.
                // By default this call is blocking, which means it will wait
                // for a message to arrive on the queue.
                Message message;
                message = consumer.receive();

                // There are many types of Message and TextMessage
                // is just one of them. Producer sent us a TextMessage
                // so we must cast to it to get access to its .getText()
                // method.
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("Получено сообщение '"
                            + textMessage.getText() + "'");
                }
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                System.out.println("Получаем сообщение каждые 2 секунду");
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                LOG.warn(ex);
            }
        }
    }
}
