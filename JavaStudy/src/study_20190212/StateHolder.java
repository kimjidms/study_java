package study_20190212;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

public class StateHolder {
	 	private List<Listener> listeners = new ArrayList<>();
	 	private int state;
	 	
	 	public void addListener(Listener l) { listeners.add(l); }
	 	public void removeListener(Listener l) { listeners.remove(l); }
	 	public void setState(int state) {
	 		int oldState = this.state;
	 		this.state = state;
	 		Event event = new Event(this, oldState, state);
	 		for (Listener l : listeners) l.stateChanged(event);
	 	} 
}

@FunctionalInterface
public interface Listener {
	void stateChanged(Event event);
}
