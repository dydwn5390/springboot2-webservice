package com.springboot.book;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 모두 자동으로 설정
//여기 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최 상단에 위치
@SpringBootApplication
//앞으로 만들 클래스의 메인 클래스
public class Application {
    public static void main(String[] args) {
        //내장 was 실행
        //별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것
        SpringApplication.run(Application.class, args);
    }

}