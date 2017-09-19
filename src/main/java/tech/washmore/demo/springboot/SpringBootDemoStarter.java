package tech.washmore.demo.springboot;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tech.washmore.demo.springboot.fx.controller.MainViewController;

/**
 * @author Washmore
 * @version V1.0
 * @summary SpringBoot程序入口
 * @Copyright (c) 2017, www.washmore.tech
 * @since 2017/6/13
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootDemoStarter extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        try {
            // SpringApplication.run(SpringBootDemoStarter.class, args);
            launchApp(SpringBootDemoStarter.class, MainViewController.class, args);
            System.out.println("---------------正常启动--^_^------------#####################################");
        } catch (Exception e) {
            System.out.println("---------------启动挂了--T_T------------#####################################");
        }

    }
}
