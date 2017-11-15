package tech.washmore.demo.springboot;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.washmore.demo.springboot.p2p.EchoServerHandler;

/**
 * @author Washmore
 * @version V1.0
 * @summary SpringBoot程序入口
 * @Copyright (c) 2017, www.washmore.tech
 * @since 2017/6/13
 */
@SpringBootApplication
public class SpringBootDemoStarter implements CommandLineRunner {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringBootDemoStarter.class, args);
            System.out.println("---------------正常启动--^_^------------#####################################");
        } catch (Exception e) {
            System.out.println("---------------启动挂了--T_T------------#####################################");
        }

    }


    @Override
    public void run(String... strings) throws Exception {
        Bootstrap b = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new EchoServerHandler());

            b.bind(7402).sync().channel().closeFuture().await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
