package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 컴포넌트 스캔을 사용하면 @configuration이 붙은 설정 정보도 자동으로 등록되기 때문에
// 앞에 미리 만들어놓은 설정 정보를 제외하기 위해 excludeFilter 사용
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


}
