import java.util.*;
/***
 * 
 * @author samar
 *States variable myMap
 */
public class EfficientWordMarkov extends BaseWordMarkov{
	private Map<WordGram, ArrayList<String>> myMap;
	/***
	 * 
	 * @param order
	 * Uses order from BaseWordMarkov
	 * Initializes myMap as a new HashMap with two parameters
	 */
	public EfficientWordMarkov(int order){
		super(order);
		myMap = new HashMap<WordGram, ArrayList<String>>();
	}
	/***
	 * same as BaseWordMarkov and initializes myMap with two parameter
	 */
	public EfficientWordMarkov() {
		this(3);
		myMap = new HashMap<WordGram, ArrayList<String>>();
	}
	/***
	 * adds word grams that we are looking for with appropriate letter after the word gram.
	 * Changes myMap
	 */
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
		
			
	/***
	 * checks if myMap has a wordGram
	 * @returns the key from myMap
	 */
	@Override
	public ArrayList<String> getFollows(WordGram kGram) {
		if (!myMap.containsKey(kGram))
		{
			throw new NoSuchElementException(kGram+" not in map");
		}

		return myMap.get(kGram);
		}
		
			
	}