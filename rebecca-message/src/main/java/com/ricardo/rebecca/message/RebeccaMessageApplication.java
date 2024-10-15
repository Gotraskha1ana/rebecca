package com.ricardo.rebecca.message;

import com.ricardo.rebecca.common.constant.RebeccaConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Class RebeccaMessageApplication
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/14 20:45
 */
@Slf4j
@EnableDubbo
@SpringBootApplication
public class RebeccaMessageApplication implements CommandLineRunner {
    @Value("${server.port}")
    private String serverPort;

    public static void main(String[] args) {
        SpringApplication.run(RebeccaMessageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(AnsiOutput.toString(RebeccaConstant.REBECCA_BANNER, "\n", AnsiColor.GREEN, RebeccaConstant.REBECCA, AnsiColor.DEFAULT, AnsiStyle.FAINT));
        log.info("Rebecca start succeeded, Index >> http://127.0.0.1:{}/", serverPort);
        log.info("Rebecca start succeeded, Knife4j >> http://127.0.0.1:{}/doc.html", serverPort);
    }
}
