/**
 * 
 */
package com.dashboard.service.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import com.dashboard.service.vo.DashboardVO;

/**
 * @author aashuGupta
 *
 */
public class FootballScoringDashboardHelper {

	public static String validateAndStartGame(Map<String, List<DashboardVO>> record, String input, StringTokenizer st) {
		String resultStr = "";

		// check High level validation to ensure that start command syntax is as
		// expected.
		if (!validateStartCommand(st, input)) {
			System.out.println(
					"input error-please start a game through typing 'Start: '<Name of Home Team>' vs. '<Name of Away Team>'");
			resultStr = "input error-please start a game through typing 'Start: '<Name of Home Team>' vs. '<Name of Away Team>'";
			return resultStr;
		}
		int tokenCount = st.countTokens();
		for (int i = 0; i < (tokenCount); i++) {
			String val = st.nextToken();
			if (i == 1) {
				// initialize the map with home team and empty score list
				record.put(val.trim(), new ArrayList<DashboardVO>());
			}
			if (i == 3) {
				// initialize the map with away team and empty score list
				record.put(val.trim(), new ArrayList<DashboardVO>());

			}

		}
		System.out.println("Game started");
		resultStr = "Game started";

		return resultStr;
	}

	private static boolean validateStartCommand(StringTokenizer token, String inputString) {
		boolean result = false;
		if (token.countTokens() == 4 && inputString.contains("vs.")) {
			result = true;
		}
		return result;
	}

	public static boolean isGameStarted(Map<String, List<DashboardVO>> recordMap) {
		return ((recordMap.size() > 0 ? true : false));

	}

	public static String validateAndUpdateScore(Map<String, List<DashboardVO>> record, StringTokenizer st) {
		String resultStr = "";
		DashboardVO dashboardVO = new DashboardVO();
		List<String> scoreMetaList = validateAndReturnScoreMetaData(record,st);
		if(scoreMetaList.size() >=3){
			dashboardVO.setMinute(scoreMetaList.get(0));
			dashboardVO.setName(scoreMetaList.get(2));
			record.get(scoreMetaList.get(1)).add(dashboardVO);
			resultStr = "Scoreboard updated";
		}else{
			resultStr = "input error-please type 'print' for game details";
		}
		return resultStr;
	}

	public static List<String> validateAndReturnScoreMetaData(Map<String, List<DashboardVO>> record, StringTokenizer st){
		List<String> scoreMetaList= new ArrayList<String>();
		String teamName="";
		int tokenCount = st.countTokens();
		for (int i = 0; i < (tokenCount); i++) {
			String val = st.nextToken();
			if (i == 0) {
				try {
					// validation to ensure that goal time is in valid format.
					int minute = Integer.parseInt(val.trim());
					scoreMetaList.add(0, val.trim());
				} catch (NumberFormatException ex) {
					return scoreMetaList;
				}
			}
			// Get scorer team name and ensure that it is one of the team given
			// while starting game.
			else if (i == 1) {
				teamName = val.trim();
				if (!(record.containsKey(teamName))) {
					return scoreMetaList;
				}else{
					scoreMetaList.add(1, val.trim());
				}
			} else if (i == 2) {
				String scorer = val;
				if (scorer.trim().length() > 0) {
					scoreMetaList.add(2, val.trim());
				} else {
					return scoreMetaList;
				}

			}

		}
		
		return scoreMetaList;
	}
	
	public static String printGameStats(Map<String, List<DashboardVO>> record, String input) {
		String resultString = "";
		String tempScorerString = "";

		Set<String> recordSet = record.keySet();
		for (String tName : recordSet) {
			List<DashboardVO> list = record.get(tName);
			int noOfGoals = list.size();
			for (DashboardVO dVO : list) {
				String playerName = dVO.getName();
				String minute = dVO.getMinute();
				tempScorerString = tempScorerString + playerName + " " + minute + "' ";

			}
			String teamRecord = tName + " " + noOfGoals + " (" + tempScorerString + ") ";
			tempScorerString = "";
			if (resultString.trim().length() > 0) {
				resultString = resultString + " vs. " + teamRecord;
			} else {
				resultString = teamRecord;
			}

		}

		return resultString;
	}

	public static String endGame(Map<String, List<DashboardVO>> record) {
		record.clear();
		return "Game Ended successfully";
	}
	
	public static boolean isValidNonStartCommand(Map<String, List<DashboardVO>> record,String input,StringTokenizer st){
		boolean result=false;
		if(input.trim().equalsIgnoreCase("'end'")){
			result=true;
		}else if(input.trim().equalsIgnoreCase("'print'")){
			result=true;
		}else if(st.countTokens() == 3){
			List<String> scoreMetaList = validateAndReturnScoreMetaData(record, st);
			if(scoreMetaList.size() == 3){
				result=true;
			}
		}
		return result;
	}

}
