
public class PerfectHashedStructure<T> {
	//Fields
	int keyMin;
	int keyMax;
	int size;
	T[] data;
	
	//Constructors
	PerfectHashedStructure(int keyMinValue, int keyMaxValue) {
		keyMin = keyMinValue;
		keyMax = keyMaxValue;
		size = keyMaxValue - keyMinValue;
		data = (T[]) new Object[size];
	}
	
	//Methods
	public boolean insert(Object newObject) {
		KeyMode newNode = (KeyMode) newObject;
		int pk = (int) newNode.getKey() - keyMin;
		if (data[pk] == null) {
			data[pk] = (T) newNode.deepCopy();
			return true;
		} else {
			return false;
		}
	}
	
	public T fetch(int targetKey) {
		int pk = targetKey - keyMin;
		if (data[pk] == null) {
			return null;
		} else {
			KeyMode fetchedNode = (KeyMode) data[pk];
			return (T) fetchedNode.deepCopy();
		}
	}
	
	public boolean delete(int targetKey) {
		int pk = targetKey - keyMin;
		if (data[pk] == null) {
			return false;
		} else {
			data[pk] = null;
			return true;
		}
	}
	
	public boolean update(T newObject, int targetKey) {
		int pk = targetKey - keyMin;
		if (data[pk] == null) {
			return false;
		} else {
			KeyMode newInfo = (KeyMode) newObject;
			int newPK = (int) newInfo.getKey() - keyMin;
			data[pk] = null;
			data[newPK] = (T) newInfo.deepCopy();
			return true;
		}
	}
	
	public void showAll() {
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null) {
				System.out.println(data[i]);
			}
		}
	}
}
