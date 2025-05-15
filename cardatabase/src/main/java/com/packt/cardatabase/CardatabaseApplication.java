package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.packt.cardatabase.domain.CarRepositoory;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	//여기서 CardatabaseApplication의 repositoory필드로 선언
	private final CarRepositoory repositoory;
	private final OwnerRepository oRepository;
	
	// 생성자 주입을 통한 CarRepositoory/OwnerRepository
	public CardatabaseApplication(CarRepositoory repositoory, OwnerRepository oRepository) {
		this.repositoory = repositoory;
		this.oRepository = oRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("애플리케이션 실행");
	}

	@Override
	public void run(String... args) throws Exception {
		//owner 댇체를 생성하여 DB에 저장
		Owner owner1 = new Owner("Johe", "Jonson");
		Owner owner2 = new Owner("Maty", "Robinson");
		Owner owner3 = new Owner("금수", "완");
		oRepository.saveAll(Arrays.asList(owner1, owner2, owner3));
		
		repositoory.save(new Car("Ford", "Mustang", "Red", "ADF-11121", 2023, 5900, owner1));
		repositoory.save(new Car("Mossan", "Leaf", "Whute", "SSJ-3002", 2024, 2900, owner2));
		repositoory.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 3900, owner3));

		//모든 자동차 엔티티를 다 찾아내서 Console창에 로깅
		for (Car car : repositoory.findAll()){
			logger.info("브랜드: {}, 모델명: {}", car.getBrand(), car.getModel());
		}
	}
}
