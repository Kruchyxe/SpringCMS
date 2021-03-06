package pl.coderslab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("cmsPersistenceUnit");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory
    ){
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(getAuthorConverter());
//    }
//
//    @Bean
//    public AuthorConverter getAuthorConverter() {
//        return new AuthorConverter();
//    }

}
