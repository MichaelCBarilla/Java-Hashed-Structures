
public class LqHashed<T> {
	//Fields
	int N;												//Max number of storage locations
	int n = 0;											//Number of nodes in the structure
	int defaultQuotient = 9967;			//Arbitrary 4k + 3 prime
	double loadingFactor = 0.75;		
	T deleted;										//Dummy node, v2 (v1 = null)
	private T[] data;								//Primary storage array
	
	//Constructors
	public LqHashed(int length, T dummy) {
		int pct = (int) ((1.0 / loadingFactor - 1) * 100.0);
		N = fourKPlus3(length, pct);
		data = (T[]) new Object[N];
		deleted =dummy;
		for (int i = 0; i < N; i++) {
			data[i] = null;
		}
	}
	
	//Methods
	public boolean insert(T newObject) {
		boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		KeyMode newNode = (KeyMode) newObject;
		int pk = stringToInt((String) newNode.getKey());
		if ((((double) n) / N) < loadingFactor) {
			pass = 0;
			q = pk / N;
			offset = q;
			ip = pk % N;
			if (q % N == 0) {
				offset = defaultQuotient;
			}
			while (pass < N) {
				if (data[ip] == null || data[ip] == deleted) {
					hit = true;
					break;
				}
				ip = (ip + offset) % N;
				pass++;
			}
			if (hit == true) {
				data[ip] = (T) newNode.deepCopy();
				n++;
				return noError = true;
			} else {
				return noError = false;
			}
		} else {
			return noError = false;
		}
	}
	
	public T fetch(Object targetKey) {
		boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		int pk = stringToInt((String)targetKey);
		pass = 0;
		q = pk / N;
		offset = q;
		ip = pk % N;
		if (q % N == 0) {
			offset = defaultQuotient;
		}
		while (pass < N) {
			if (data[ip] == null) { 															//Node not in structure
				break;
			}
			if (((KeyMode) data[ip]).compareTo(targetKey) == 0) { 		//Node found
				hit = true;
				break;
			}
			ip = (ip + offset) % N;
			pass++;
		}
		if (hit == true) {
			return (T) ((KeyMode) data[ip]).deepCopy();
		} else {
			return null;
		}
	}
	
	public boolean delete(Object targetKey) {
		boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		int pk = stringToInt((String) targetKey);
		pass = 0;
		q = pk / N;
		offset = q;
		ip = pk % N;
		if (q % N == 0) {
			offset = defaultQuotient;
		}
		while (pass < N) {
			if (data[ip] == null) {																//Node not in structure
				break;
			}
			if (((KeyMode) data[ip]).compareTo(targetKey) == 0) {		//Node found
				hit = true;
				break;
			}
			ip = (ip + offset) % N;
			pass++;
		}
		if (hit == true) {
			data[ip] = deleted;
			n--;
			return noError = true;
		} else {
			return noError = false;
		}
	}
	
	public boolean update(Object targetKey, T newObject) {
		boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		int pk = stringToInt((String) targetKey);
		KeyMode newInfo = (KeyMode) newObject;
		pass = 0;
		q = pk / N;
		offset = q;
		ip = pk % N;
		if (q % N == 0) {
			offset = defaultQuotient;
		}
		while (pass < N) {
			if (data[ip] == null) {																//Node not in structure
				break;
			}
			if (((KeyMode) data[ip]).compareTo(targetKey) == 0) {		//Node found
				hit = true;
				break;
			}
			ip = (ip + offset) % N;
			pass++;
		}
		if (hit == true) {
			data[ip] = deleted;
		} else {
			return noError = false;
		}
		hit = false;
		KeyMode newNode = (KeyMode) newObject;
		pk = stringToInt((String) newNode.getKey());
		if ((((double) n) / N) < loadingFactor) {
			pass = 0;
			q = pk / N;
			offset = q;
			ip = pk % N;
			if (q % N == 0) {
				offset = defaultQuotient;
			}
			while (pass < N) {
				if (data[ip] == null || data[ip] == deleted) {
					hit = true;
					break;
				}
				ip = (ip + offset) % N;
				pass++;
			}
			if (hit == true) {
				data[ip] = (T) newNode.deepCopy();
				return noError = true;
			} else {
				return noError = false;
			}
		} else {
			return noError = false;
		}
	}
	
	public void showAll() {
		for (int i = 0; i < N; i++) {
			if (data[i] != null && data[i] != deleted) {
				System.out.println(data[i].toString());
			}
		}
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
}
