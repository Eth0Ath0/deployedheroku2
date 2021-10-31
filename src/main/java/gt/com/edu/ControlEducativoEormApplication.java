package gt.com.edu;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import gt.com.edu.model.services.IUsuarioService;




@SpringBootApplication
public class ControlEducativoEormApplication /*implements CommandLineRunner*/{
	
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;

		
	public static void main(String[] args) {
		SpringApplication.run(ControlEducativoEormApplication.class, args);
	}
	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String password="12345";
		
		//for (int i=0;i<1;i++) {
			
			String passwordBcrypt= passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}
	//}*/
	
 

}
