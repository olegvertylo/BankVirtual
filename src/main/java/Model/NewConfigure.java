package Model;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class NewConfigure extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/pages/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/pages/img/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/pages/css/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/pages/");


    }
}

