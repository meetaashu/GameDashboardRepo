package com.dashboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.dashboard.service.helper.FootballScoringDashboardHelper;
import com.dashboard.service.vo.DashboardVO;

/**
 * @author aashuGupta
 *
 */

@Path("/footballscoringdashboard/")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class FootballScoringDashboard {
	// Map which will hold the team and their goals along with scorer and
	private Map<String, List<DashboardVO>> record = new HashMap<String, List<DashboardVO>>();
	
	@GET
	@Path("/dashboard")
	public String printScore(@QueryParam("input") String input) {
		String resultStr = "";
		StringTokenizer st = new StringTokenizer(input, "'");
		// For starting game , exclude the case when game is already started and
		// someone tries to start again
		if (input.startsWith("Start:") && (!FootballScoringDashboardHelper.isGameStarted(record))) {
			resultStr = FootballScoringDashboardHelper.validateAndStartGame(record, input, st);
		} else if (FootballScoringDashboardHelper.isGameStarted(record) && st.countTokens() == 3) {
			//Game is started and dashboard is updated with score
			resultStr = FootballScoringDashboardHelper.validateAndUpdateScore(record, st);
		} else if (input.trim().equalsIgnoreCase("'print'") && FootballScoringDashboardHelper.isGameStarted(record)) {
			//Game is started and 'print' command is given
			resultStr = FootballScoringDashboardHelper.printGameStats(record, input);
		} else if (input.trim().equalsIgnoreCase("'end'") && FootballScoringDashboardHelper.isGameStarted(record)) {
			//Game is started and 'end' command is given
			resultStr = FootballScoringDashboardHelper.endGame(record);
		}else if((!FootballScoringDashboardHelper.isGameStarted(record)) && 
				FootballScoringDashboardHelper.isValidNonStartCommand(record, input, st)){
			//if game is not started and scoring dashboard is given any command
			System.out.println("No game currently in progress");
			resultStr = "No game currently in progress";
		}else if((!FootballScoringDashboardHelper.isGameStarted(record))){
			//For all other cases when game is not started and dashboard is not able to understand given command
			resultStr = "input error-please start a game through typing 'Start: '<Name of Home Team>' vs. '<Name of Away Team>'";
		}else{
			//Cases when game is started and an invalid command is given. Valid one already covered above.
			resultStr ="input error-please type 'print' for game details";
			
		}
		return resultStr;

		
	}

	

}
