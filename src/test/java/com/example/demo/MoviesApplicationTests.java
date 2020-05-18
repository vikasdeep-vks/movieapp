package com.example.demo;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.controller.MoviesController;
import com.example.demo.entity.Movies;
import com.example.demo.repository.MoviesRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class MoviesApplicationTests {
	
	@Test
	public void contextLoads() {
	}

}
