package Chatbot;

public class DanielLike implements Topic {
	private boolean inLikeLoop;
	private String likeResponse;
 	
	
	
	@Override
	public void talk() {
		DanielQMain.print("what are some things you like?");
		inLikeLoop= true;
		while(inLikeLoop){
			likeResponse = DanielQMain.getInput();
			int likePsn = DanielQMain.findKeyword(likeResponse, "like", 0);
			
			if(likePsn >=0){
				String thingsLiked = likeResponse.substring(likePsn+5);
				DanielQMain.print(" You are such an intersting person because you like " + thingsLiked);
				if(DanielQMain.findKeyword(thingsLiked, "school", 0)>=0){
					inLikeLoop = false;
					DanielQMain.school.talk();
					
				}
				else{
					inLikeLoop = false;
					DanielQMain.talkForever();
				}

		
			}
			else{
				DanielQMain.print("I don't understand you");
			}
			
		}
		
	}



	@Override
	public boolean isTriggered(String userInput) {
		if(DanielQMain.findKeyword(userInput, "like", 0)>=0){
			return true;
		}
		
		return false;
	}
}


