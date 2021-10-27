package gt.com.edu.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import gt.com.edu.model.services.IUsuarioService;
import gt.com.edu.models.entity.Usuario;
@Component
public class InforAdicionalToken implements TokenEnhancer {
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String,Object> info = new  HashMap<>();
		Usuario usuario=usuarioService.findBynombre_usuario(authentication.getName());
		info.put("info_adicional", "saludos:".concat(authentication.getName()));
		info.put("nombre_usuario",usuario.getId() +": "+ usuario.getNombre_usuario());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
