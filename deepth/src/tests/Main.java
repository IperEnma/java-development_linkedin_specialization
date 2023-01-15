package tests;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static boolean esAlfanumerico(String s) {
		return s != null && s.matches("^[a-zA-Z0-9]*$");
	}
	
	public static boolean parImpar(String s) {
		int letters = 0;
		int numbers = 0;
		if (s == null) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				letters++;
			} else {
				numbers++;
			}
		}
		return (letters % 2 == 0 && numbers % 2 != 0);
	}
	
	public static int password(String s)
	{
		if (s == null) {
			return -1;
		}
		String[] strings = s.split(" ");
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < strings.length; i++) {
			if (esAlfanumerico(strings[i]) && parImpar(strings[i])) {
				list.add(strings[i]);
			}
		}
		
		if (list.isEmpty()) {
			return -1;
		}
		
		int len = 0;
		for (String aux : list) {
			if (len < aux.length()) {
				len = aux.length();
			}
		}
		return len;
	}
	public static void main(String[] args) {

		String s = "aaaa999 88a";
		System.out.println("Password: " + password(s));
	}

}