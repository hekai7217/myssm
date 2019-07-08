package com.lx.activemq_topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * create by hekai  2019-07-08
 *
 * @desc Topic 消费者
 */
public class TopicConsumer {

    public static void main(String[] args) throws Exception {

        // 获取 连接工厂
        ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://192.168.43.123:61616");

        // 获取 连接对象
        Connection conn = connFactory.createConnection();

        conn.start();

        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建 topic
        Topic topic = session.createTopic("test-top");

        //创建 consumer 对象

        MessageConsumer consumer = session.createConsumer(topic);

        //接受消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

                TextMessage textMessage = (TextMessage) message;

                String text = null;

                try {
                    text = textMessage.getText();
                    System.out.println(text);

                } catch (JMSException e) {
                    e.printStackTrace();
                }


            }
        });

        System.out.println("topic的消费端05。。。。。");
        // 等待键盘输入
        System.in.read();
        // 第九步：关闭资源
        consumer.close();
        session.close();
        conn.close();


    }


}
