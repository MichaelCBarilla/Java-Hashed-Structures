
public class HashedStructure<T> {
	//Fields
	private int size;
	private T[] data;
	
	//Constructors
	HashedStructure(int nodeMax, int percentage) {
		size = fourKPlus3(nodeMax, percentage);
		data = (T[]) new Object[size];
	}
	
	//Methods
	public int fourKPlus3(int n, int pct) {
		boolean fkp3 = false;
		boolean aPrime = false;
		int prime, highDivisor, d;
		double pctd = pct;
		prime = (int) (n * (1.0 + (pctd / 100.0)));
		
		if (prime % 2 == 0) {
			prime = prime + 1;
		}
		while (fkp3 == false) {
			while (aPrime == false) {
				highDivisor = (int) (Math.sqrt(prime) + 0.5);
				for (d = highDivisor; d > 1; d--) {
					if (prime % d == 0) {
						break;
					}
				}
				if (d != 1) {
					prime = prime + 2;
				} else {
					aPrime = true;
				}
			}
			if ((prime - 3) % 4 == 0) {
				fkp3 = true;
			} else {
				prime = prime + 2;
				aPrime = false;
			}
		}
		return prime;
	}
	
	public int stringToInt(String aKey) {
		int pk = 0;
		int n = 1;
		int cn = 0;
		char[] c = aKey.toCharArray();
		int grouping  = 0;
		while (cn < aKey.length()) {
			grouping = grouping << 8;
			grouping = grouping + c[cn];
			cn++;
			if (n == 4 || cn == aKey.length()) {
				pk = pk + grouping;
				n = 0;
				grouping = 0;
			}
			n++;
		}
		return Math.abs(pk);
	}
}
