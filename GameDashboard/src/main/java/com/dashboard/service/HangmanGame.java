package com.dashboard.service;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.dashboard.service.helper.HangmanGameHelper;

@Path("/hangmangame/")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class HangmanGame {
	
	Object[] secretWordArray=new Object[]{"january","february","march","april","may","june","july","august","september","october","november","december"};
	Object[] hangmanArray=new Object[]{"Head","left eye","right eye","nose","mouth","body","left arm","right arm","left leg","right leg"};
	Set<String> userIncorrectHangmanList;
	Set<String> userCorrectHangmanSet;
//	List<String> incorrectHangmanList=new ArrayList<String>();
//	for(int i=0;i<hangmanArray.length;i++){
//		incorrectHangmanList.add((String)hangmanArray[i]);
//	}
	static int count,hangmanValue;
	String secretword=null;
	
	@GET
	@Path("/hangman")
public String startGame(@QueryParam("input") String input){
	String result =null;
	
	//Logic to start the game:Step 1
	if(input.equalsIgnoreCase("Start")){
		result=HangmanGameHelper.validateStartGame();
		//userIncorrectHangmanList=new ArrayList<String>();
		//incorrectHangmanList=new ArrayList<String>();

//		Random generator=new Random();
//		int randomIndex=generator.nextInt(secretWordArray.length);
//		secretword=(String)secretWordArray[randomIndex];
//		result="Game started.Please enter any letter from a to z or guess a word to guess the secret word.";
//		return result;
	}
	
	//Step2:when user gives an entry
	//to match every character or word with the secret word
	else if(!input.equalsIgnoreCase("Start")&&(input.length()==1)){
		//String str2=null;
		
		//try{
	//if(input.length()==1){
		result=HangmanGameHelper.validateGameProgressWithLetter(input);
//		String str1=null;
//		String[] stringOfArray=secretword.split("");
//		for(int i=0;i<stringOfArray.length;i++){
//			
//			if(input.equalsIgnoreCase(stringOfArray[i])){
//				userCorrectHangmanSet.add(input);
//				for(String userGuess:userCorrectHangmanSet){
//					 str1=str1+" "+userGuess;
//				}
//				result="Correct guess for secretword:"+str1;
//				if(str1.length()==secretword.length()){
//					result="Wooooow....you have guessed all the letters of secret word.Make your word and enjoy;)";
//				}
//				return result;
//			}
//			
//		}
	//}
	}
	else if(!input.equalsIgnoreCase("Start")&&(input.length()>1)){
		result=HangmanGameHelper.validateGameProgressWithWord(input);
//		if(input.equalsIgnoreCase(secretword)){
//			result="You won.";
//			return result;
//		}
	}
	
		//Add hangman for incorrect letters or words
			//userCorrectHangmanSet.add(input);
//			for(String userGuess:userCorrectHangmanSet){
//				str=str+" "+userGuess;
//			}
//			result=str;
	
//	userIncorrectHangmanList.add(incorrectHangmanList.iterator().next());
//	if(userIncorrectHangmanList.size()==incorrectHangmanList.size()){
//		result="You lost all the attempts.Better luck next time";
//		return result;
//	}
	
////	userIncorrectHangmanList.add((String)hangmanArray[hangmanValue]);
////	hangmanValue++;
////	for(String userGuess:userIncorrectHangmanList){
////		 str2=str2+" "+userGuess;
////	}
////	result="Your Hangman sequence is:"+str2;
////	
////	if(userIncorrectHangmanList.size()==hangmanArray.length){
////		result="You lost all the attempts.Better luck next time"+"Your Hangman sequence is:"+str2;
////		return result;
////	}
////	
//			}
//		//catch(Exception ex){
//				 //count=0;
//				//count++;
//				if(count>1){
//					count++;
//				//userCorrectHangmanSet.add("_");
////				for(String userGuess:userCorrectHangmanSet){
////					str=str+" "+userGuess;
////				}
////				result="Hangman sequence:"+str;
////				}
//					userIncorrectHangmanList.add((String)hangmanArray[hangmanValue]);
//					hangmanValue++;
//					for(String userGuess:userIncorrectHangmanList){
//						 str2=str2+" "+userGuess;
//					}
//					result="Your Hangman sequence is:"+str2;
//					
//					if(userIncorrectHangmanList.size()==hangmanArray.length){
//						result="You lost all the attempts.Better luck next time"+"Your Hangman sequence is:"+str2;
//						return result;
//					}
//				}
//				result="warning:Same letter is repeated again.Next time it will be counted as an incorrect pick.";
//				count++;
//		
//		return result;
//		//}
//}
	return result;
}
}