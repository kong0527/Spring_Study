package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.context.annotation.ComponentScan.Filter;

public @interface ComponentAppConfigTest {

    @Test
    void fileterScan() {
        ApplicaitionContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull(); // beanA는 스프링 빈에 등록했기 때문에 조회 되어야 함
        Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class)
        ); // beanB는 exclude했기 때문에 조회되지 않아야 함
    }

    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )

    static class ComponentFilterAppConfig {

    }

}
