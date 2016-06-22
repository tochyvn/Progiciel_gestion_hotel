package library;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class Validator {
	
	/**
	 * Pattern que doit respecter un numero de telephone en france
	 */
	public final static String REGEXP_PHONE = "^0[1-8]([-. ]?[0-9]{2}){4}$";
	/**
	 * Pattern que doit respecter une adresse email
	 */
	public final static String REGEXP_EMAIL = "^[a-z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$";
	
	
	/**
	 * 
	 * @param la valeur à tester
	 * @param regexp constante predefinie representant le format a respecter (email, telehone)
	 * @return retourne true si oui et false si non
	 */
	public static boolean regexp(String valeur, String regexp) {
		
		Pattern pattern = Pattern.compile(regexp);
		
		return pattern.matcher(valeur).matches();
	}
	
	/**
	 * Permet de savoir si une valeur est entière
	 * @param nombre nombre a tester
	 * @return retourne true si oui c'est un nombre sinon false
	 */
	public static boolean validateNombre(String nombre) {
		boolean bool = true;
		try {
			Double d = Double.valueOf(nombre);
		} catch (Exception e) {
			bool = false;
		}
		
		return bool;
	}
	/**
	 * Tester si une chaine est vide
	 * @param chaine la chaine à tester
	 * @return retourne true si elle est vide, sinon retourne false
	 */
	public static boolean isEmpty(String chaine) {
		boolean bool = true;
		if (!chaine.equals("")) {
			bool = false;
		}
		return bool;
	}
	
	/**
	 * Verifie si la longueur d'une est strictement inferieure à une valeur max donnée
	 * @param chaine la chaine à tester
	 * @param max la valeur max
	 * @return retourne true si celle-ci est inferieure à la valeur max
	 */
	public static boolean lengthIsLowerThan(String chaine, Integer max) {
		
		boolean bool = true;
		byte[] tab = chaine.getBytes();
		if (tab.length >= max) {
			bool = false;
		}
		return bool;
	}
	
	public static boolean hasLength(String chaine, Integer length) {
		boolean bool = true;
		byte[] tab = chaine.getBytes();
		if (tab.length != length) {
			bool = false;
		}
		return bool;
	}
	
	/**
	 * Methode permettant d'afficher un double avec une précision de 2 chiffres après la virgule
	 * @param value represente la valeur double à convertir
	 * @return
	 */
	public static double convertToDouble(double value) {
		
		String pattern = ".##";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		output = output.replace(',', '.');
		
		double converted = Double.valueOf(output);
		
		return converted;
	}
	
	public static void main(String[] args) {
		System.out.println(Validator.regexp("lion.tochlion@yaho.fr", Validator.REGEXP_EMAIL));
	}

}
