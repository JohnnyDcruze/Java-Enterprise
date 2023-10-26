package webmvcdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"webmvcdemo"}) // Replace with the actual package where your controllers are located
public class SpringConfiguration implements WebMvcConfigurer {

	  @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	    }
}
