package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

/**
 * jason을 받은 데이터에 대한 객체
 */
@Getter @Setter
public class HelloData {
    private String username;
    private int age;
}
