package com.lx.spring;

import org.w3c.dom.Text;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * create by hekai  2019-07-08
 *
 * @desc
 */
public class MyMsgListener implements MessageListener {

    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;

        //取 消息
        String text = null;
        try {
            text = textMessage.getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }

        System.out.println("msg : " + text);

    }

}
