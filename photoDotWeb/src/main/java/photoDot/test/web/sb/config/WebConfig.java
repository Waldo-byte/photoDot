package photoDot.test.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({})
@Configuration
@ComponentScan(basePackages = {
        "photoDot.test.web.sb.controller"
})

public class WebConfig {
}
