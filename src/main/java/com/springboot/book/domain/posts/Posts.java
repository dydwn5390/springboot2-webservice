//Entity 클래스, setter를 절대 만들지 않음 (메소드로 변경)
package com.springboot.book.domain.posts;


import com.springboot.book.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
//기본 생성자 자동 추가, public Posts() 와 같은 효과
@NoArgsConstructor
//jpa 어노테이션, 테이블과 링크될 클래스임을 나타냄
@Entity
public class Posts extends BaseTimeEntity {

    //해당 테이블의 PK 필드
    @Id
    //PK의 생성 규칙을 나타냄, 스프링부트2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨 (오라클은 .SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //테이블의 칼럼을 나타냄, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
    //기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    //문자열 기본 값 VARCHAR(255)
    @Column(length=500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
