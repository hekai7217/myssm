package com.lx.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * create by hekai  2019-07-08
 * @desc  同步消费
 */
public class ActiveMqP2pConsumer {

    public static void main(String[] args) throws Exception{

        // 创建一个 连接工厂
        ConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://192.168.43.123:61616");

        // 创建 一个连接
        Connection conn = connFactory.createConnection();

        //打开连接
        conn.start();

        //创建一个回话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建一个  目的地
        Queue queue = session.createQueue("myTest01");

        // 创建一个消费者
        MessageConsumer consumer = session.createConsumer(queue);

        while (true){
            //设置消费 接受时间
            Message msg = consumer.receive(20000);

            if (msg != null){

                TextMessage textMessage = (TextMessage) msg;
                System.out.println(textMessage.getText());

            }else {

                // 超时 结束
                System.out.println("超时 ...");
                break;

            }
        }

        consumer.close();
        session.close();
        conn.close();

    }
}
