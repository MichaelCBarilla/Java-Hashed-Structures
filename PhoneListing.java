
public class PhoneListing implements KeyMode {
	//Fields
	private String name;
	private String address;
	private String number;
	
	//Constructors
	PhoneListing() {
		name = "";
		address = "";
		number = "";
	}
	PhoneListing(String n, String a, String num) {
		name = n;
		address = a;
		number = num;
	}
	
	//Methods
	public String toString() {
		return ("Name is " + name +
					"\nAddress is " + address +
					"\nNumber is " + number + 
					"\n");
	}
	
	public KeyMode deepCopy() {
		PhoneListing clone = new PhoneListing (name, address, number);
		return clone;
	}
	
	public int compareTo(Object targetKey) {
		String tKey = (String) targetKey; 
		return (name.compareTo(tKey));
	}
	
	public String getKey() {
		return name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
}