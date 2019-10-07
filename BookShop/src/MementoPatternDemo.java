
public class MementoPatternDemo {

	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.createMemento());
		originator.setState("State #3");
		careTaker.add(originator.createMemento());
		originator.setState("State #4"); 
		System.out.println("Current State: " + originator.getState());
		originator.setMemento(careTaker.get(0));
		System.out.println("First saved State: " + originator.getState());
		originator.setMemento(careTaker.get(1)); 
		System.out.println("Second saved State: " + originator.getState());
		

	}

}
