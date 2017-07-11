package tech.washmore.demo.springboot.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Washmore on 2017/7/8.
 */
@Component
public class WakeUpTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(WakeUpTask.class);

    @Scheduled(cron = "0 22 8 * * ?")
    public void wakeUp() throws Exception {
        try {
            Process process = Runtime.getRuntime().exec("E:\\Program Files (x86)\\Tencent\\QQMusic\\QQMusic.exe");
            LOGGER.info("程序开始启动:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
