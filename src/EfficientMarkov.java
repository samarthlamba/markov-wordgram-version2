import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	EfficientMarkov(int order){
		super(order);
		myMap = new HashMap<>();
	}
	public EfficientMarkov() {
		this(3);
	}
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
	public ArrayList<String> getFollows(String key){
		if (!myMap.containsKey(key))
		{
			throw new NoSuchElementException(key+" not in map");
		}

		return myMap.get(key);
		}
		
			
	}
	

