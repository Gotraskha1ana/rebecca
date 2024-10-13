package com.ricardo.rebecca.web;

import com.ricardo.rebecca.common.constant.RebeccaConstant;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Class RebeccaApplication
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/11 21:58
 */
@Slf4j
@SpringBootApplication
public class RebeccaApplication implements CommandLineRunner {
    @Value("${server.port}")
    private String serverPort;

    public static void main(String[] args) {
        SpringApplication.run(RebeccaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(AnsiOutput.toString(RebeccaConstant.REBECCA_BANNER, "\n", AnsiColor.GREEN, RebeccaConstant.REBECCA, AnsiColor.DEFAULT, AnsiStyle.FAINT));
        log.info("Rebecca start succeeded, Index >> http://127.0.0.1:{}/", serverPort);
        log.info("Rebecca start succeeded, Knife4j >> http://127.0.0.1:{}/doc.html", serverPort);
    }
}