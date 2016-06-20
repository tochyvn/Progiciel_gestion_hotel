package library;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cryptographie {
	
	/**
	 * Encode une chaine en MD5
	 * @param password
	 * @return
	 */
	public static String encodePassword(String password) {
		
		byte[] uniqueKey =  password.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		StringBuffer hashString = new StringBuffer();
		for ( int i = 0; i < hash.length; ++i ) {
			String hex = Integer.toHexString(hash[i]);
			if ( hex.length() == 1 ) {
			  hashString.append('0');
			  hashString.append(hex.charAt(hex.length()-1));
			} else {
			  hashString.append(hex.substring(hex.length()-2));
			}
		}
		
		return hashString.toString();
	}
	
	
	/**
	 * Teste si une chaine correspond à une valeur encodée
	 * @param clearTextTestPassword chaine non encodée
	 * @param encodedActualPassword chaine encodée
	 * @return true s'il ils correspondent sinon retourne false
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean testPassword(String clearTextTestPassword, String encodedActualPassword) {

		String encodedTestPassword = Cryptographie.encodePassword(clearTextTestPassword);

		return (encodedTestPassword.equals(encodedActualPassword));
	}
	
	
	public static void main(String[] args) {
		String password = "tochlion";
		String passwordEncrypted = Cryptographie.encodePassword(password);
		System.out.println(passwordEncrypted);
		System.out.println(Cryptographie.testPassword("tochlion", "ff52185b0fc2b0bf35677abe1527e15e"));
	}
}
