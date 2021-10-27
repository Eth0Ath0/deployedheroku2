package gt.com.edu.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
// copiamos todo el método y lo pegamos en springsecurity config
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// Configuración para acceso a los endpoints del backen por roles
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/calificaciones/listar").permitAll()
		/*.antMatchers("/api/calificaciones/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/profesores/**").hasRole("ADMIN")
		.antMatchers("/api/aulas/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/clases/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/contenidos/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/cursos/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/estudiantes/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/grados/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/matriculas/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/responsables/**").hasAnyRole("PROFESOR","ADMIN")
		.antMatchers("/api/roles/**").hasRole("ADMIN")
		.antMatchers("/api/usuarios/**").hasAnyRole("PROFESOR","ADMIN")
	
			
		//para cualquier otra ruta el usuario debe estar autenticado*/
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}

// configuración de los cors para que otras aplicaciones de otro origenes tengan acceso al backen 
@Bean
public CorsConfigurationSource corsConfigurationSource() {
	
	CorsConfiguration config=new CorsConfiguration();
	
	config.setAllowedOrigins(Arrays.asList("*"));
	config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
	config.setAllowCredentials(true);
	config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
	UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**", config);
	return source;
}

@Bean
public FilterRegistrationBean<CorsFilter> corsFilter(){
	
	FilterRegistrationBean<CorsFilter> bean= new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return bean;
		
	
}
	
	
}
