package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    // Lombok은 getter, setter를 자동으로 만들어준다.
    // 생성자 관련도 지원
    // ToString도 지원

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("adfjkljad");
        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
