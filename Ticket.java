
public class Ticket implements KeyMode {
	//Fields
	private String name;
	private int ticketNumber;				//Key
	
	//Constructors
	Ticket(String n, int tN) {
		name = n;
		ticketNumber = tN;
	}
	
	//Methods
	@Override
	public String toString() {
		return name + 
					"\n" + ticketNumber +
					"\n";
		
	}
	@Override
	public KeyMode deepCopy() {
		Ticket clone = new Ticket(name, ticketNumber);
		return clone;
	}
	
	@Override
	public int compareTo(Object targetKey) {
		int key = (int) targetKey;
		if (key > this.ticketNumber) {
			return -1;
		} else if (key < this.ticketNumber) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public Object getKey() {
		return this.ticketNumber;
	}
}
