import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov{
	private Map<WordGram, ArrayList<String>> myMap;
	
	public EfficientWordMarkov(int order){
		super(order);
		myMap = new HashMap<WordGram, ArrayList<String>>();
	}
	public EfficientWordMarkov() {
		this(3);
		myMap = new HashMap<WordGram, ArrayList<String>>();
	}
	@Override
	public void setTraining(String text){
		myWords = text.split("\\s+");
		myMap.clear();
		for (int i = 0; i < myWords.length-myOrder+1;i=i+1) {
			myMap.putIfAbsent(new WordGram(myWords, i,myOrder), new ArrayList <String>()); 
			if (i+ myOrder+1 > myWords.length)
			{
				myMap.get(new WordGram(myWords, i,myOrder)).add(PSEUDO_EOS);
			}
			else {				
				myMap.get(new WordGram(myWords, i,myOrder)).add(myWords[i+myOrder]);
		}
		}
	}
		
			
	
	@Override
	public ArrayList<String> getFollows(WordGram kGram) {
		if (!myMap.containsKey(kGram))
		{
			throw new NoSuchElementException(kGram+" not in map");
		}

		return myMap.get(kGram);
		}
		
			
	}