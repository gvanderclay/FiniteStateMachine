import java.util.HashMap;

public class State {

	private HashMap<Character, State> transition;
	
	private String name;
	
	private boolean accept;
	
	public State(String name, boolean accept){
		this.transition = new HashMap<Character, State>();
		this.name = name;
		this.accept = accept;
	}
	
	public State nextState(char stateName){
		Character c = new Character(stateName);
		if(transition.containsKey(new Character(c))){
			return transition.get(c);
		}
		else{
			return null;
		}
	}
	
	public boolean isAccept(){
		return accept;
	}
	
	public void addTransition(char c, State state){
		this.transition.put(c, state);
	}
	
	public String getName(){
		return this.name;
	}
}
