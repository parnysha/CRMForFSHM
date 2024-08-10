package org.example.crmforfshm.configuraion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/styles/css/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/");
    }
}
