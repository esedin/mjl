package org.yard42.l.java;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApplication{
    public static void main(String[] args) {
        //BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Triangle triangle = (Triangle) context.getBean("triangle-name");
        triangle.draw();
     }
}
