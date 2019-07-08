package com.lx.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * create by hekai  2019-07-08
 *
 * @desc
 */
public class ActiveMqP2pProducer {

    public static void main(String[] args) throws Exception {

        //创建一个连接工厂

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.43.123:61616");

        //从 工厂对象中获取 连接
        Connection conn = connectionFactory.createConnection();

        //开启连接
        conn.start();

        //开启一个 会话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建一个 目的地 queue
        Queue queue= session.createQueue("myTest01");

        //创建 一个生产者
        MessageProducer producer = session.createProducer(queue);

        //创建 msg
        TextMessage msgTxt = new ActiveMQTextMessage();
        msgTxt.setText(" hello msg ");

        //发送消息
        producer.send(msgTxt);

        //关闭
        producer.close();
        session.close();
        conn.close();


    }

}
