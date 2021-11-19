package translator.config;

import repo.config.RepositoryConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = "translator")
public class TranslatorConfig {
}
