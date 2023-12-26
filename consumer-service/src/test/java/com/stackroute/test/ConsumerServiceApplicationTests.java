package com.stackroute.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
@SpringBootTest
@SpringBootApplication
@ContextConfiguration(classes = ConsumerServiceApplicationTests.class)
public class ConsumerServiceApplicationTests {

    @Test
    void contextLoads() {
    }
}
