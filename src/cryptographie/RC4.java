package cryptographie;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RC4 {
	   private static String algorithm = "RC4";
	   public static byte[] encrypt(String toEncrypt, String key) throws Exception {
		      SecureRandom sr = new SecureRandom(key.getBytes());
		      KeyGenerator kg = KeyGenerator.getInstance(algorithm);
		      kg.init(sr);
		      SecretKey sk = kg.generateKey();
		      Cipher cipher = Cipher.getInstance(algorithm);
		      cipher.init(Cipher.ENCRYPT_MODE, sk);
		      byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());
		      return encrypted;
		   }
		  
		   public static byte[] decrypt(byte[] toDecrypt, String key) throws Exception {
		      SecureRandom sr = new SecureRandom(key.getBytes());
		      KeyGenerator kg = KeyGenerator.getInstance(algorithm);
		      kg.init(sr);
		      SecretKey sk = kg.generateKey();
		      Cipher cipher = Cipher.getInstance(algorithm);
		      cipher.init(Cipher.DECRYPT_MODE, sk);
		      byte[] decrypted = cipher.doFinal(toDecrypt);
		      return decrypted;
		   }
}
