package corsi.prog2.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("corsi.prog2.springmvc")
public class AppConfig implements WebMvcConfigurer {

    /* Configuración del despacho de JSPs */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setViewClass(JstlView.class);
        vr.setPrefix("/vistas/");
        vr.setSuffix(".jsp");
        return vr;
    }

    /* Configuración del contenido estático (CSS, JS, IMG, etc.) */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry reg) {
        reg.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    /* Inyección de dependencias en el contructor de CervezasRepMySQL */
    @Bean(name = "dbName")
    public String getDBName() { return "cerveceria"; }

    @Bean(name = "dbURL")
    public String getDBURL() { return "192.168.56.101"; }

    @Bean(name = "dbUser")
    public String getDBUser() { return "root"; }

    @Bean(name = "dbPswd")
    public String getDBPswd() { return "admin"; }

}
