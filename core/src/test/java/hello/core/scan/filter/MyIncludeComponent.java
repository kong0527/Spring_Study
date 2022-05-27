package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Rentention(RententionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
