package com.example.jms.jmsdemo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import static java.lang.System.*;

/**
 * Created by gkaur on 30/06/2017.
 */
@Component
public class JmsReceiver {

    @JmsListener(destination = "sampleQueue")
    public void receiveMessage(String msg) {
        out.println("Received :" + msg);
    }

    @JmsListener(destination = "NewSampleQueue")
    public void receiveMessage(ObjectMessage message) throws JMSException {

        out.println(message.getObject());
        out.println("userDetails:" + message);
    }
}
