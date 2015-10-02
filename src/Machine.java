import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Machine {

	public static void main(String args[]){
		
		char[] withoutFiveAndSeven = {'1','2','3','4','6'};
		char[] all = {'1','2','3','4','5','6','7'};
		
//		for(int s = 0; s <= 4; s++){
//			for(int f = 0; f <= 2; f++){
//				String stateName = "s" + s + "f" + f;
//				System.out.println("State " + stateName + " = new State(\"" + stateName + "\", false);" );
//				System.out.println("addMultipleSelfStateTransitions(" + stateName + ", withoutFiveAndSeven);");
//			}
//		}
//		
//		for(int s = 0; s <= 4; s++){
//			for(int f = 0; f <= 2; f++){
//				String stateName = "s" + s + "f" + f;
//				String statePlusF = "s" + s + "f" + (f+1);
//				String statePlusS = "s" + (s+1) + "f" + f;
//				System.out.println(stateName + ".addTransition(\'" + 5 + "\', " + statePlusF + ");");
//				System.out.println(stateName + ".addTransition(\'" + 7 + "\', " + statePlusS + ");");
//			}
//		}
		
		State s0f0 = new State("s0f0", false);
		s0f0.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s0f1 = new State("s0f1", false);
		s0f1.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s0f2 = new State("s0f2", false);
		s0f2.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s1f0 = new State("s1f0", false);
		s1f0.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s1f1 = new State("s1f1", false);
		s1f1.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s1f2 = new State("s1f2", false);
		s1f2.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s2f0 = new State("s2f0", false);
		s2f0.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s2f1 = new State("s2f1", false);
		s2f1.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s2f2 = new State("s2f2", false);
		s2f2.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s3f0 = new State("s3f0", false);
		s3f0.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s3f1 = new State("s3f1", false);
		s3f1.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s3f2 = new State("s3f2", true);
		s3f2.addMultipleSelfStateTransitions(withoutFiveAndSeven);
		State s4 = new State("s4", false);
		s4.addMultipleSelfStateTransitions(all);

		s0f0.addTransition('5', s0f1);
		s0f0.addTransition('7', s1f0);
		s0f1.addTransition('5', s0f2);
		s0f1.addTransition('7', s1f1);
		s0f2.addTransition('5', s0f2);
		s0f2.addTransition('7', s1f2);
		s1f0.addTransition('5', s1f1);
		s1f0.addTransition('7', s2f0);
		s1f1.addTransition('5', s1f2);
		s1f1.addTransition('7', s2f1);
		s1f2.addTransition('5', s1f2);
		s1f2.addTransition('7', s2f2);
		s2f0.addTransition('5', s2f1);
		s2f0.addTransition('7', s3f0);
		s2f1.addTransition('5', s2f2);
		s2f1.addTransition('7', s3f1);
		s2f2.addTransition('5', s2f2);
		s2f2.addTransition('7', s3f2);
		s3f0.addTransition('5', s3f1);
		s3f0.addTransition('7', s4);
		s3f1.addTransition('5', s3f2);
		s3f1.addTransition('7', s4);
		s3f2.addTransition('5', s3f2);
		s3f2.addTransition('7', s4);
		
		try {
			processFile("test.txt", s0f0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void processFile(String fileName, State startState) throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    int i = 1;
		    while ((line = br.readLine()) != null) {
		       System.out.println("PROCESSING LINE " + i + "\n----------------");
		       boolean isAccepted = transition(line, startState);
		       if(isAccepted){
		    	   System.out.println("Input is accepted");
		       }
		       else{
		    	   System.out.println("Input is not accepted");
		       }
		       System.out.println("----------------");
		    }
		}
	}
	
	public static boolean transition(String input, State startState){
		State nextState = startState;
		System.out.println(nextState.getName());
		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			nextState = nextState.nextState(c);
			if(nextState == null){
				return false;
			}
			System.out.println(nextState.getName());
		}
		return nextState.isAccept();
	}
	
}
