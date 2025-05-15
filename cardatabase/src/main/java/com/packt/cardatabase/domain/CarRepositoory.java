package com.packt.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepositoory extends CrudRepository<Car, Long> {
    //브랜드로 자동차 검색
//    @Query("select c from Car c where c.brand=?1")
//    List<Car> findByBrand(String brand);
//
//    //색상으로 자동차 검색
//    List<Car>  findByColor(String color);
//
//    //자동차 생산년도를 통해 자동차를 검색
//    List<Car> findByModelYear(int modelYear);
//
//    //브랜드와 모델로 자동차 검색
//    List<Car> findByByBrandAndModel(String brand,String model);
//
//    //브랜드 또는 색상별로 자동차 가져오기
//    List<Car> findByByBrandOrColor(String brand, String color);
//
//    //브랜드를 자동차로 검색하고 연도로 정렬
//    List<Car> findByByBrandOrderByModelYearAsc(String brand);

    //SQL문을 이용하여 브랜드로 자동차를 검색(근데 LIKE 사용하는 예시)
//    @Query("select c from Car c where c.brand like %1");
//    List<Car> findByByBrandEndsWith(String brand);
}
