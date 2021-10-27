package gt.com.edu.auth;

public class JwtConfig {
public static final String LLAVE_SECRETA ="clave.secreta.159357";

public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
		"MIIEowIBAAKCAQEAwRRkppjNSOZkENkh8/JNk7vjVq1J7jRWT89ZrgOYbS7BkKDX\r\n" + 
		"YYo3ylxi/Z7aQE5SYP1RIuz0Iw8ZuCsPr4Sh4nbkbWIPnthTB0ZWizmQCC2La81H\r\n" + 
		"U78zMCw0AetdGVU0+P0LAh+9lZAdXiZiTqFviNbOj/pfJqyPz6r9/7/HUDVuxpeO\r\n" + 
		"KXQO7PMhsQrwCAkj7oxVdXyoKjByyx1vz19A9sZgKrWhthhg409ngy3/RRTtzXqf\r\n" + 
		"gg6RgUNIeKmhQjC4E+1K8JtG3dBCFpGuZaCc/Y+PO4aj7c2JaQ2BtQvw9ZmlQmIA\r\n" + 
		"RlrD2wTfkld/gnsah9KPAUGzSK2Am2jiTTVnXwIDAQABAoIBAFYkOg+VxqjKmURn\r\n" + 
		"C13h8biCsBfAsmZDFWsAEHuxgPTdUmCrUcxjtSZkd4m9sJPWHazF98gEPZvSpd/j\r\n" + 
		"3lipbOwzrRAcGun8i3aIbB4rbVYos7ZB3JvBhx3r6rwcfOnLeRnJE3s8HAI5TNDv\r\n" + 
		"gRahsbg0Ve4ofwErJfI50J6kulDO75w2yAMefthdLDy9wqtCTwE/elcmZ3318GB+\r\n" + 
		"ctJeuemkDoyLTbaDrh98erewpz2WRCxXqTV9mDVzfsL/4Vqky9iCcF4ZhMYkhk22\r\n" + 
		"26UVfHUAd0Ovfe5KMUzGRpH0gc6FdSrkGfsWV0gp9anm2cwFeTKiVJmv2eo93yEn\r\n" + 
		"MySolpkCgYEA4IZIzyTSZ2pwRkM8QITjwYN7KsQlcu3kCxnf1h7LIPKWgbr5P6OU\r\n" + 
		"t842TYFMODCb/CCoX4Oe9YON+hkP+BDlcMvlmArO296gQV3mtsuMWChkRTmQ0fB9\r\n" + 
		"X7ryqpz9ry3i/RKydU+mPyFD5DbEn363gTv+K0OxmX26bItLn3rCgOMCgYEA3CWe\r\n" + 
		"HLX33o5x1NHAKCB9c/fObX/60uQwVQocGWyfeDleI8G22PAIL5K3Ns+s0RFcHVDJ\r\n" + 
		"IXicZ52ceVCCTpzw1KBX9f6ah9cVxIRV0UelSgC8nj4IivDsUcn8YIai1rNzfPCt\r\n" + 
		"5d6iN2SqnP4vDpp8hTOZR5d0j0W2FbVwsFzLtFUCgYEAgLqdLh7Xf7GYE8Di378R\r\n" + 
		"clb3HCr/qahZUkAQhQx8vDQ6NMFFvMYGM2hI3CEg2SqNlH4I61JkpjE6CsWp0Tmm\r\n" + 
		"wwg0Z/ryZT98NF4pNG751WW7L7F0pdmzmFpwXX/LN1Agz6aTqQz0rUdeTI9WJngZ\r\n" + 
		"sD/8V0PlpLJgW3F190cEE68CgYAj3YkN2mOAgapv5qAsqWZm30dlNYVymDR7lkMP\r\n" + 
		"rU+psYbxwlx8qVZcEcYBiwH3qaFdMU0jQ9gPVXEpnoEsN4tQyLKr5Afe+56TPpAQ\r\n" + 
		"oWB/VvFjwm133VpS1NpmC2k6G1BEWZ2rJoM9DQxyuUKHWYnR1Z8yN62Ire3FSaML\r\n" + 
		"SILzZQKBgFzwPCDsrBbNi2I0zzSuPptinosyEMwp4Fx/V0JpOMcB37k2wEbpN7v5\r\n" + 
		"LbwCiTtzS6oxWfY2yOA6eICTX2Eiu5a5MP/uShsBCKRR2dGuqxD3K3TmiWielY34\r\n" + 
		"+E+YwC7OKZiSJ97cePVhMbTt5RrIkXSuQbjWAdZkC5BAUJEWTpvl\r\n" + 
		"-----END RSA PRIVATE KEY-----";

public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
		"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwRRkppjNSOZkENkh8/JN\r\n" + 
		"k7vjVq1J7jRWT89ZrgOYbS7BkKDXYYo3ylxi/Z7aQE5SYP1RIuz0Iw8ZuCsPr4Sh\r\n" + 
		"4nbkbWIPnthTB0ZWizmQCC2La81HU78zMCw0AetdGVU0+P0LAh+9lZAdXiZiTqFv\r\n" + 
		"iNbOj/pfJqyPz6r9/7/HUDVuxpeOKXQO7PMhsQrwCAkj7oxVdXyoKjByyx1vz19A\r\n" + 
		"9sZgKrWhthhg409ngy3/RRTtzXqfgg6RgUNIeKmhQjC4E+1K8JtG3dBCFpGuZaCc\r\n" + 
		"/Y+PO4aj7c2JaQ2BtQvw9ZmlQmIARlrD2wTfkld/gnsah9KPAUGzSK2Am2jiTTVn\r\n" + 
		"XwIDAQAB\r\n" + 
		"-----END PUBLIC KEY-----";




/*
public static final String RSA_PRIVADA= "-----BEGINPRIVA TE KEY-----\r\n"
		+ "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDe7OmRvxFp7BvP\r\n"
		+ "zztKoOVdJ0wGIDYIq9Zeg6zGVXE+70HGRGZEahx9++EZU1OjU++I9wvuPAjdZS34\r\n"
		+ "tcjXA4kXNsblPXKq/iatAGS+kPfB8s3/em2279VQQHlu1hpZAKxFTfNY/lKTC6hn\r\n"
		+ "8Yl2R2TmmBtnvjzpCh5fgfXAylUR87oC2ID/W0xxPvEauJlH6dkpVNqkrn0WcZym\r\n"
		+ "qBhCNsKNSdFjm9lTWsw6HH7SEUBtx5J6/f4T5fWBrfaa9IY2O0kMi6Bo7d2vsZlf\r\n"
		+ "quILuu2kHIfkHaak+ldjZmu96sxUJw/kBAvcmn8dkn/XDHOow1AWScC9He5Xhw2D\r\n"
		+ "sbZOjgk7AgMBAAECggEAJQtUcvI/yAzCwGEs9qVPCBBQK1Jt+Dnp6RHTg6/OHkmu\r\n"
		+ "8e4K2oKRkoPpL4avxtvbWbTH6EJUrMmz/nji04wUW2WwXoa8B9ss/SGsHBjF+xZI\r\n"
		+ "khQ7qCMpnOjh5P+yKCka93dRIXA9s47D4OX71Epf44vSPgaYY5dZXcCgYHWe9ljt\r\n"
		+ "D49e3a3Zxuer0stBkH29jN6vJZB+twsJMI/cr/+9SFSgMIy2sG2+DP8l7bw5hl8o\r\n"
		+ "bj6INju9NygBlOqY0L2S8t3cdlTye7zU87Z2tjRC2+3o2Mfv7LxgY9kQ093hADnR\r\n"
		+ "nV2NGGsAftKRtxMX3wsDABh42dMhaNlf+DmXoxmqIQKBgQD5YnHCHKSx8jGotIbw\r\n"
		+ "XoHTjEPO0DVN2bOZCED6jsT3UUcfFpwNL+dL/rhgwz1mlo2gk3v0nK/WRE37D5cA\r\n"
		+ "SSxNy2blgFS4dC7/JRUiFWjGAOkzyNXtWWUSVXccussf2g4w+ZIFILmph70Brt/t\r\n"
		+ "AswZx677xvt2fSmKmbrxlJpcIQKBgQDk1skohg5y/LtYQVtpPOsnOb7Csdg6NsoF\r\n"
		+ "RhA0rpqVS+0/AgbbBtJT2H5dSzNyWaAoJf1dtSEYshGhC5ohOh29PsARC2Do8fNB\r\n"
		+ "BQ/ngiC3/OJUYliYyAhJApIBni5VUsNMW9mG/8Nt777j5AJJIMR+z58zn8h6mo+z\r\n"
		+ "10BJ+0IZ2wKBgQC1SSv6+Ml8ldwlkH4bVAg6WVedituE6UHWeBqMSabDRnFWFyB/\r\n"
		+ "sZgJNXSg2qzS25S+6xeLvS9Rqjupyy5wxcCQGNGG+iAcKlFTpohTS47riRP9Ufy5\r\n"
		+ "WmfPyRMabmtkjyYL0hCk66IrrAHorFAZwhPOlcsNOhvoiZneKFyuauE/IQKBgGJh\r\n"
		+ "UKPiVi3rJ2O+3Vy1+uanNbKgILSOP3Xa9Dah5gVPWhSfe3EIUr4HMfRL0zdS/r6j\r\n"
		+ "7nQt3aevTlLtGPs17/kfFBV/zc73zbtjQL4nvIc86dSbXzl3rdAtkbWuWn8GEL4w\r\n"
		+ "MqmOJWeLDYcNzEnCE5ftDKV2CQtkjWkknhfwNC/HAoGBAMwiRCT3VFXmL70s1oWs\r\n"
		+ "4Mn5hEJjCcpGlzmEe6kZRDyjg9GXnWMfMXvzS7eMcpvtsDKzX0LOgo3gVH4O7WiY\r\n"
		+ "e1/YXKUAROx/2bqdTmMxrzKHvJhldRr8IKFnMwsN2hir9JBFfVVK0choUg+uUWbN\r\n"
		+ "nw0VxdEeieixI+0hudW+aihc\r\n"
		+ "-----END PRIVATE KEY-----";

public static final String RSA_PUBLICA= "-----BEGIN PUBLIC KEY-----\r\n"
		+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3uzpkb8Raewbz887SqDl\r\n"
		+ "XSdMBiA2CKvWXoOsxlVxPu9BxkRmRGocffvhGVNTo1PviPcL7jwI3WUt+LXI1wOJ\r\n"
		+ "FzbG5T1yqv4mrQBkvpD3wfLN/3pttu/VUEB5btYaWQCsRU3zWP5SkwuoZ/GJdkdk\r\n"
		+ "5pgbZ7486QoeX4H1wMpVEfO6AtiA/1tMcT7xGriZR+nZKVTapK59FnGcpqgYQjbC\r\n"
		+ "jUnRY5vZU1rMOhx+0hFAbceSev3+E+X1ga32mvSGNjtJDIugaO3dr7GZX6riC7rt\r\n"
		+ "pByH5B2mpPpXY2ZrverMVCcP5AQL3Jp/HZJ/1wxzqMNQFknAvR3uV4cNg7G2To4J\r\n"
		+ "OwIDAQAB\r\n"
		+ "-----END PUBLIC KEY-----";*/
}
