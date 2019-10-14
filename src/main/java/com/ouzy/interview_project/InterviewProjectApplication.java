package com.ouzy.interview_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication/*(exclude = DataSourceAutoConfiguration.class)*/
public class InterviewProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(InterviewProjectApplication.class, args);
    }

}
