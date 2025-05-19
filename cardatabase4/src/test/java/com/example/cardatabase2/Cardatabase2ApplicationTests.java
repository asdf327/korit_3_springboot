package com.example.cardatabase2;

import com.example.cardatabase2.web.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Cardatabase2ApplicationTests {

	@Autowired
	private CarController controller; //private CarController carController = new CarController();

	@Test
	@DisplayName("첫 번째 텍스트 : controller 필드 생성 성공")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
