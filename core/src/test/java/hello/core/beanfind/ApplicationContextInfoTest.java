package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

/*    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beaDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beaDefinitionName);
            System.out.println("name = " + beaDefinitionName + " object = " + bean);
        }
    }  */

    // ctrl + D 누르면 그대로 복사 가능
    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beaDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beaDefinitionName);

            // 개발하기 위해 등록한 bean
            // ROLE_INFRASTRUCTURE 는 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beaDefinitionName);
                System.out.println("name = " + beaDefinitionName + " object = " + bean);
            }
        }
    }
}
