package com.myproject.admin;

import com.myproject.admin.dto.MasAdminParam;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringStartTests {

    public static void main(String[] args) {
//        ClassPathResource resource = new ClassPathResource("springAnalysis.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);
//        MasAdminParam masAdminParam = (MasAdminParam) factory.getBean("masAdminParam");
//        System.out.println(masAdminParam.getUserName());

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springAnalysis.xml");
        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        MasAdminParam messageService = context.getBean(MasAdminParam.class);
        // 这句将输出: hello world
        System.out.println(messageService.getUserName());
    }



}
