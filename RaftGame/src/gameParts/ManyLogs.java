package gameParts;

import java.lang.Math;

public class ManyLogs {
	
	private Log[][] logs = new Log[5][2];
	private int randX = 0;
	private int otherRandX = 0;
	
	public ManyLogs(){
		
		for(int i = 0; i <= 4; i++){
			randX = (int)(Math.random() * 450);
			otherRandX = (int)((Math.random() * 50)+250);
			logs[i][0] = new Log(randX, (i-1)*250, 2);
			logs[i][1] = new Log(randX + otherRandX, (i-1)*250, 2);
		}
	}
	
	public Log[][] getLogs(){
		return logs;
	}
}
