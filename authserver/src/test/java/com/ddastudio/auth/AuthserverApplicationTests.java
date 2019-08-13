package com.ddastudio.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthserverApplicationTests {

    @Test
    public void contextLoads() {

        Jwt decode = JwtHelper.decode("yJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NjQ0OTU3NTAsInVzZXJfbmFtZSI6IjAxMDk5ODkxOTEzIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6ImQ2NGY5NjE4LTQyZGQtNDg4My04MDA3LTNkNzQzNDBjOWYzMCIsImNsaWVudF9pZCI6ImZpc2hpbmciLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.M4BpPaqJp7o9Yi8uTxo2JisfuWB660sS7uRico3T9lSGOwVll8W0oCONFqi8VLfSdyw6a0tFJ41w6MGsOSZoD8esC-73n6iWUAIZl4NASd1jEev58K2Vy9JkAm5gEl1kgo9Txza9vIcUZ7CF59tT4nhmB0herq7nKx9qbmO12VlMqBXsk2QQNRUBEn6_iP6AozrYwVvixRQhaaE3mw6hMo1JeW7ESWVcdZWyr5PF-hLroFAJdGLUy2wp6otM3iQHHxk5spcnHr6Uplq_5EZGtSKoeEo4tf1DYzEjeTk3Fxk9ndAb8JhOQwDrXuIRnN2Ssz3TK-gAU-Dg5DOu0Q4a4A");
        String claims = decode.getClaims();
        System.out.println(claims);
    }

}
