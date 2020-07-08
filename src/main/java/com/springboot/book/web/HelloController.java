package com.springboot.book.web;


import com.springboot.book.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    //HTTP Method인 Get 요청을 받을 수 있는 api를 만들어줌
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    //@RequestParam: 외부에서 api로 넘긴 파라미터를 가져오는 어노테이션
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }


}
