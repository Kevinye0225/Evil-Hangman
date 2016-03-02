import java.util.ArrayList;
import java.util.HashMap;
/*
 * Captures the word pattern and keep track of where the letter appears in a word
 * @author Kevin
 */
public class WordFamily {
	public HashMap<String, ArrayList<String>> family;
	
	public WordFamily(){
		this.family = new HashMap<String, ArrayList<String>>();
	}
	
	/*
	 * generate word family based on the letter entered by user
	 */
	public void generateFamily(ArrayList<String> available, String letter){
		ArrayList<String> tempList = new ArrayList<String>();
		ArrayList<String> valueList = new ArrayList<String>();
		//word family starts with empty list every time a new letter entered
		this.family = new HashMap<String, ArrayList<String>>();
		
		// loop through the current available word list and find the words that contains letter
		for (int i = 0; i < available.size(); i++){
			
			if (available.get(i).contains(letter)){
				tempList.add(available.get(i));
			} else {
				// if it is the first word that get put into the map
				if (family.get("Zero") != null){
					valueList = family.get("Zero");
				}
				valueList.add(available.get(i));
				family.put("Zero", valueList);
			}
		}
		// put the matching into the hash map based on the word pattern
		for (int i = 0; i < tempList.size(); i++){
			valueList = new ArrayList<String>();
			String key = "";
			for (int j = 0; j < tempList.get(i).length(); j++){
				String temp = tempList.get(i).substring(j, j+1);
				if (temp.equals(letter)){
					key += letter + j;
				}
			}
			if (family.get(key) != null){
				valueList = family.get(key);
			}
			valueList.add(tempList.get(i));
			family.put(key, valueList);
		}
	}
	
	
	/*
	 * read the key and convert it into a list of index with matching letter
	 */
	public ArrayList<Integer> readKey(String key){
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		if (key.equals("Zero")){
			return indexList;
		}
		int i = 0;
		while (i < key.length()){
			Character temp = key.charAt(i);
			String tempIndex = "";
			int index = 0;
			if (Character.isLetter(temp)){
				i++;
				while (i < key.length() && !Character.isLetter(key.charAt(i))){
					tempIndex += key.substring(i, i+1);
					i++;
				}
			}
			index = Integer.parseInt(tempIndex);
			indexList.add(index);
		}
		
		return indexList;
	}
	
}
