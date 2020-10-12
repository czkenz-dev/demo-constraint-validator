package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testHelloUserValid() {
        HttpEntity<User> request = new HttpEntity<>(new User("abcABC..."));
        ResponseEntity<User> response = restTemplate.postForEntity("/hello", request, User.class);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("abcABC...", response.getBody().getEngName());
    }

    @Test
    void testHelloUserInvalid() {
        HttpEntity<User> request = new HttpEntity<>(new User("ทดสอบชื่อภาษาอังกฤษ"));
        ResponseEntity<User> response = restTemplate.postForEntity("/hello", request, User.class);
        assertEquals(400, response.getStatusCode().value());
    }

}