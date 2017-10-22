package anagrams;

import java.util.ArrayList;

public class AnagramsChecking {

	public AnagramsChecking() {
		
	}

	public static void main(String[] args) {
		String s1= "anagram"; String s2="nag a ram";
		if(checkIfTwoStringsAreAnagrams(s1, s2)) {
			System.out.println(s2 + " is an anagram of " +s1);
		}
		else {
			System.out.println(s2 + " is not an anagram of " +s1);
		}		
	}
	public static boolean checkIfTwoStringsAreAnagrams(String s1, String s2)
	{
		boolean isAnagrams = false; boolean matchedChar = false;
		s1 = s1.toLowerCase(); 
		int length = s1.length(); 
		//Count the number of a specific character in a string
		int characterCount = 0;
		char currentChar = ' ';
		//Store the already processed character of string s1
		ArrayList<Character> listOfPreviousCharacter = new ArrayList<Character>(' ');
		for(int i = 0; i <= length-1; i++)
		{
			currentChar = s1.charAt(i); characterCount =0;
			//skip empty space
			if(currentChar ==' ') continue;
		
			//only process a character if it has not been processed before
			if(!listOfPreviousCharacter.contains(currentChar)) {
				//count the number of time the same character is in the string
				for(int j = i; j <= length-1; j++)
				{
					if(currentChar == s1.charAt(j)) {
						characterCount++;
					}
				}
				listOfPreviousCharacter.add(currentChar);
			
				
				//call the private method to check if the current character is in the second string
				matchedChar = checkIfSecondStringHasSameCharacterAsFirstString(s2, currentChar, characterCount);
				
				//No match character in the second string, get out of the loop, no anagram
				if(!matchedChar) break;				
			}			
		}
		//all characters in both strings match, they are anagram
		if(matchedChar) isAnagrams = true;

		return isAnagrams;
	}
	//check if a specific character in the first string is also in the second string
	private static boolean checkIfSecondStringHasSameCharacterAsFirstString(String s, char c, int count) {
		s = s.toLowerCase();
		boolean match = false;
		int length = s.length();
		int charCount = 0;
		for(int i = 0; i <= length-1; i++) {
			//skip the empty character
			if(s.charAt(i) == ' ') continue;
			//compare character in the second string with that of the first one	
			//and increment the count
			if(s.charAt(i) == c) {
				charCount++;			
			}						
		}
		
		//The current character is a match
		if(charCount == count) {
			match = true;
		}
		return match;
	}

}
