package com.lx.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * create by hekai  2019-07-08
 *
 * @desc
 */
public class QueueConsumer {

    public static void main(String[] args) throws  Exception {

        //连接 工厂
        ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://192.168.43.123:61616");

        //创建 连接
        Connection conn = connFactory.createConnection();

        // 打开连接
        conn.start();

        //创建回话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建 一个 目的地 destination
        Queue myTest01 = session.createQueue("myTest01");

        //创建一个消费者

        MessageConsumer consumer = session.createConsumer(myTest01);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

                if (message instanceof TextMessage){

                    String text = "";

                    try {
                        System.out.println(((TextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        System.in.read();

        // 关闭
        consumer.close();
        session.close();
        conn.close();
    }
}
