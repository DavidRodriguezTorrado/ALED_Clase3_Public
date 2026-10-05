package palindromo;

public class Palindromo {
	
	public static boolean isPalindrome(String s) {
		if (s.length() <= 1) {
			System.out.println("La frase tiene que tener longitud > 1.");
			return false;
		}
		
		s = s.toLowerCase();
		
		int inicio = 0;
		int fin = s.length() - 1;
		
		while (fin > inicio) {
			if (s.charAt(inicio) == ' ') {
				inicio++;
				continue;
			}
			if (s.charAt(fin) == ' ') {
				fin--;
				continue;
			}
			
			if (s.charAt(inicio) != s.charAt(fin)) {
				return false;
			}
			inicio++;
			fin--;
			
		}
		
		return true;
	}
	
	
	public static boolean isPalindromeMalo (String s) {
		if (s.length() <= 1) {
			System.out.println("La frase tiene que tener longitud > 1.");
			return false;
		}
		
		s = s.toLowerCase();
		
		String sentenceClean = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			sentenceClean += s.charAt(i);
		}
		
		for (int i = 0; i < sentenceClean.length(); i++) {
			for (int j = 0; j < sentenceClean.length(); j++) {
				if (i + j == sentenceClean.length() - 1) {
					if (sentenceClean.charAt(i) != sentenceClean.charAt(j)) {
						return false;
					}
				}
			}
		}
		
		
		return true;
	}
	
	
	public static void main(String[] args) {
		String s = "Anita lava la tina";
		System.out.println(isPalindrome(s));
		System.out.println(isPalindromeMalo(s));
	}

}
