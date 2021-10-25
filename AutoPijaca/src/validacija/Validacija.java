package validacija;

public class Validacija {

	//ispis parametara
	public void ispisiParametre(String username, String password, String repeatedPassword, String userType) {
		
		System.out.println("Nasi parametri su: ");
		System.out.println("User name: " +username);
		System.out.println("Password: " +password);
		System.out.println("RepeatedPass: " +repeatedPassword);
		System.out.println("Type Usera: " +userType);

	}
	
	//metoda za checkiranje passworda
	public boolean validacijaPass(String password) {
		
		int passLength = password.length();
		
		if(passLength < 8) {
			System.out.println("Pass length failed");
			return false;
		}
		
		int digit = 0;
		int upperCase = 0;
		
		for(int i = 0; i<passLength; i++) {
			char localCharacter = password.charAt(i);
			
			if(Character.isDigit(localCharacter)) {
				digit++;
			}else if(Character.isUpperCase(localCharacter)) {
				upperCase++;
			}
		}
		
		if(digit >= 1 && upperCase >= 2) {
			System.out.println("Pass is valid and matches the parameters...");
			return true;
		}else {
			System.out.println("Pass not valid!");
			return false;
		}
		
		
	}

	public boolean repeatedPassCheckMethod(String password, String repeatedPassword) {
		
		boolean check = false;
		
		if(password.equals(repeatedPassword)) {
			check = true;
		}
		
		return check;
	}

	public boolean loginNullProvera(String userName, String password) {
		
		if(userName.isEmpty() || password.isEmpty()) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
	
	
	
}
