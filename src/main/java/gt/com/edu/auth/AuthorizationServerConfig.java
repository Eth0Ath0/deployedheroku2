package gt.com.edu.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
    
	@Autowired

	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager  authenticationManager;

	//click derecho override e implementamos los 3 métodos
	
	
	@Autowired
	private InforAdicionalToken infoAdicionalToken;
	
	@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// permitimos acceso a todos para loguearse
		security.tokenKeyAccess("permitAll()")
		//permitimos acceso y verificación del token al endpoint de autenticación 
		.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// colocamos los clientes que accederan al backend en nuestro caso angular
		clients.inMemory().withClient("angularapp")
		//colocamos una contraseña y la codificamos con el password enconder
		.secret(passwordEncoder.encode("123456"))
		//establecemos los permisos que la aplicación tendrá, leer y escribir
		.scopes("read","write")
		//indicamos de que manera accederá el cliente "credenciales" username y contraseña y obtenemos token
		//.authorizedGrantTypes("password","refresh_token")
		.authorizedGrantTypes("password")
		//definimos el tiempo de expiración de la sessión y el token en segundos para la app se dejará en 1 hora 3600
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(3600);
	}

	@Override
		
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList( infoAdicionalToken,accessTokenConverter()));
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore())
		.accessTokenConverter(accessTokenConverter())
	
		.tokenEnhancer(tokenEnhancerChain);
	}
	@Bean
    public JwtTokenStore tokenStore() {
		
		return new JwtTokenStore(accessTokenConverter());
	}

//click en accessTokenConverter y agregar metodo
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		
		JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVADA);
		jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA);
				return jwtAccessTokenConverter;
	}
	
	
	
	
	
}
