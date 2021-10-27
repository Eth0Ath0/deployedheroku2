package gt.com.edu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
//@Configurable
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	
	private UserDetailsService usuarioService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
// clic derecho sources -> override implements methods y se leccionamos authenticationManagerBuider
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
	}
	// utilizado en el authorizationServerConfig
	@Bean("authenticationManager")
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
				return super.authenticationManager();
	}
	//viene del ResourceServerConfig
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// Configuración para acceso a los endpoints del backen por roles
		http.authorizeRequests()
		//para cualquier otra ruta el usuario debe estar autenticado
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
