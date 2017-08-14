package com.dashboard.service.helper;

import java.util.Random;
import java.util.Set;

public class HangmanGameHelper {
	static Object[] secretWordArray=new Object[]{"january","february","march","april","may","june","july","august","september","october","november","december"};
	static Object[] hangmanArray=new Object[]{"Head","left eye","right eye","nose","mouth","body","left arm","right arm","left leg","right leg"};
	static Set<String> userIncorrectHangmanList;
	static Set<String> userCorrectHangmanSet;
	static int count,hangmanValue;
	static String secretword,result=null;
	
	public static String validateStartGame(){
		Random generator=new Random();
		int randomIndex=generator.nextInt(secretWordArray.length);
		secretword=(String)secretWordArray[randomIndex];
		result="Game started.Please enter any letter from a to z or guess a word to guess the secret word.";
		return result;
	}
	
	public static String validateGameProgressWithLetter(String input){
		String str1=null;
		String[] stringOfArray=secretword.split("");
		for(int i=0;i<stringOfArray.length;i++){
			
			if(input.equalsIgnoreCase(stringOfArray[i])){
				userCorrectHangmanSet.add(input);
				for(String userGuess:userCorrectHangmanSet){
					 str1=str1+" "+userGuess;
				}
				result="Correct guess for secretword:"+str1;
			}
				else if(input.equalsIgnoreCase(stringOfArray[i])&&(str1.length()==secretword.length())){
					result="Wooooow....you have guessed all the letters of secret word.Make your word and enjoy;)";
				}
				else if(!(input.equalsIgnoreCase(stringOfArray[i]))){
					result=incorrectHangmanGuess();
				}
			}
				return result;	
	}
	
	public static String validateGameProgressWithWord(String input){
		if(input.equalsIgnoreCase(secretword)){
			result="You won.";
			
	}else{
		result=incorrectHangmanGuess();
	}
		return result;
	}
	
	public static String incorrectHangmanGuess(){
		String str2="";
		userIncorrectHangmanList.add((String)hangmanArray[hangmanValue]);
		hangmanValue++;
		for(String userGuess:userIncorrectHangmanList){
			 str2=str2+" "+userGuess;
		}
		result="Your Hangman sequence is:"+str2;
		
		if(userIncorrectHangmanList.size()==hangmanArray.length){
			result="You lost all the attempts.Better luck next time"+"Your Hangman sequence is:"+str2;
			
		}
		return result;
	}
}
