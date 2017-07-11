package tech.washmore.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

/**
 * @author Washmore
 * @version V1.0
 * @summary SpringBoot程序入口
 * @Copyright (c) 2017, www.washmore.tech
 * @since 2017/6/13
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootDemoStarter {

    public static void main(String[] args) throws IOException {

        try {
            SpringApplication.run(SpringBootDemoStarter.class, args);
            System.out.println("---------------正常启动--^_^------------#####################################");
        } catch (Exception e) {
            System.out.println("---------------启动挂了--T_T------------#####################################");
        }

    }
}
