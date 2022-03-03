package it.gestionetelevisori.utility;

public class NumberUtility {
	public static Integer isInteger(String numeroInput) {
		try {
			return Integer.parseInt(numeroInput);
		} catch (Exception e) {
			return null;
		}
	}

	public static Long isLong(String numeroInput) {
		try {
			return Long.parseLong(numeroInput);
		} catch (Exception e) {
			return null;
		}
	}
}
