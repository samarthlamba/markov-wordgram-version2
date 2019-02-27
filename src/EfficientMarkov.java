import java.util.*;
/***
 * 
 * @author samar
 *Extends BaseMarov and states variables
 */
public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	/***
	 * 
	 * @param order
	 * Uses order from BaseMarkov and initializes myMap as a newHashMap
	 */
	public EfficientMarkov(int order){
		super(order);
		myMap = new HashMap<>();
	}
	/***
	 * Does the same things as BaseMarov
	 */
	public EfficientMarkov() {
		this(3);
	}
	/***
	 * trains it my putting in map a substring of order-k and has an ArrayList as the second variable
	 * if no more substrings can be made as iteration to close to end, add PSEUDO_EOS
	 * Adds the letter right after the substring we are looking for and puts as value for that key
	 */
	@Override
	public void setTraining(String t) {
		myText = t;
		myMap.clear();
		for (int i = 0; i < t.length()-myOrder+1;i=i+1) {
			myMap.putIfAbsent(t.substring(i,i+myOrder), new ArrayList <String>()); 
			if (i+ myOrder+1 > t.length())
			{
				myMap.get(t.substring(i,i+myOrder)).add(PSEUDO_EOS);
			}
			else {				
				myMap.get(t.substring(i,i+myOrder)).add(t.substring(i+myOrder, i+myOrder+1));
		}
		}
		
	}
	@Override
	/***
	 * checks if something is in the map and if not throws exception 
	 * returns the key in myMap.
	 */
	public ArrayList<String> getFollows(String key){
		if (!myMap.containsKey(key))
		{
			throw new NoSuchElementException(key+" not in map");
		}

		return myMap.get(key);
		}
		
			
	}
	

