package observer;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageStream extends Subject {

	private Deque<String> messageHistory = new ArrayDeque<String>();
	
	@Override
	public void setState(String message) {
		messageHistory.add(message);
		this.notifyObservers();
	}

	@Override
	public String getState() {
		return messageHistory.getLast();
	}

}
