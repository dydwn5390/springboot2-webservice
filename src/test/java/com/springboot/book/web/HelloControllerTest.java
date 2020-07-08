package com.springboot.book.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//웹(spring MVC)에 집중할 수 있는 어노테이션
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void return_hello() throws Exception{
        String hello = "hello";

        //체이닝이 지원되어 여러 검증을 이어서 선언 가능
        // .andExpect(status().isOK()) : HTTP Header의 Status를 검증. 여기선 Ok 즉 200이닌지 아닌지를 검증
        // .andExpect(content().string(hello) : 응답 본문의 내용 검증. Controller에서 "hello"를 리턴하기 떄문에 이 값이 맞는지 검증
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void return_hellodto() throws Exception{
        String name="hello";
        int amount = 1000;

        //param:값은 string 만 허용되므로 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 가능
        //jsonPath : json 응답 값을 필드별로 검증할 수 있는 메소드, $.를 기준으로 필드명 명시
        mvc.perform(get("/hello/dto").param("name",name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
