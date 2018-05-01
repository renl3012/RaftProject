package gameParts;

import java.lang.Math;

public class ManyLogs {
	
	private Log[][] logs = new Log[4][1];
	private int randX = 0;
	
	public ManyLogs(){
		
		for(int i = 0; i < 4; i++){
			randX = (int)(Math.random() * 800);
			logs[i][1] = new Log(randX, i*175);
		}
	}
	
	public Log[][] getLogs(){
		return logs;
	}
}