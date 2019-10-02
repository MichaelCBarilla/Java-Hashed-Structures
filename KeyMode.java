
public interface KeyMode {
	
	public abstract KeyMode deepCopy();
	
	public abstract int compareTo(Object targetKey);
	
	public abstract String toString();
	
	public Object getKey();
	
}
