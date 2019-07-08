package com.lx.activemq_topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * create by hekai  2019-07-08
 *
 * @desc  topic 生产者
 */
public class TopicProducer {

    public static void main(String[] args) throws Exception {

        // 创建 connectionFactory
        ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://192.168.43.123:61616");

        // 获取连接
        Connection conn = connFactory.createConnection();

        //启动连接
        conn.start();

        // 创建回话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建 destination

        Topic topic = session.createTopic("test-top");

        //使用session 创建 producer
        MessageProducer producer = session.createProducer(topic);

        //创建 message 对象
        TextMessage textMessage = session.createTextMessage("hello topic");

        // 使用 producer

        producer.send(textMessage);

        // 第九步：关闭资源。
        producer.close();
        session.close();
        conn.close();



    }

}
