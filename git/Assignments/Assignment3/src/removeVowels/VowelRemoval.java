package removeVowels;

public class VowelRemoval {

	public VowelRemoval() {
		
	}

	public static void main(String[] args) {
		
		System.out.println(removeVowelsFromString("nhat jason"));
	}
	
	public static String removeVowelsFromString(String input) {
		input = input.toLowerCase();
		int length = input.length();
		for(int i=0; i <= length - 1; i++) {
			if(input.charAt(i) == 'a' || input.charAt(i) == 'e' ||
					input.charAt(i) == 'i' || input.charAt(i) == 'o' ||
					input.charAt(i) == 'u' || input.charAt(i) == 'y') {
				String firstSubstring = input.substring(0, i);
				String secondSubstring = input.substring(i+1);
				input =firstSubstring.concat(secondSubstring);
				
				//reset the "for loop" variables
				length = input.length(); i=-1;
			}
		}
		return input;
	}
}
