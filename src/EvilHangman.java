
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/*
 * EvilHangman main class with play method
 * @author Kevin
 */
public class EvilHangman {
	private int wordLength;
	private StringBuilder word;
	private int wordCount;
	private int guess;
	private Dictionary dictionary;
	private ArrayList<String> usedLetter;
	private Scanner in;
	private WordFamily wordFamily;
	
	/*
	 * Constructor
	 */
	public EvilHangman(){
		dictionary = new Dictionary();
		wordFamily = new WordFamily();
		usedLetter = new ArrayList<String>();
		word = new StringBuilder("");
		wordCount = 0;

		in = new Scanner(System.in);
		do {
			System.out.println("Please enter a valid length: ");
			wordLength = in.nextInt();
		} while (!dictionary.wordSize.contains(wordLength));
		this.dictionary.updateWord(wordLength);
		System.out.println("Please enter number of guess: ");
		guess = in.nextInt();
//		in.close();
		for (int i = 0; i < this.wordLength; i++){
			word.append("_");
		}
		
	}
	

	/*
	 * This starts the game and stops when user wins or runs out of guess
	 */
	public void play(){
		in = new Scanner(System.in);
		
		while (this.wordCount < this.wordLength && guess > 0){
			
			System.out.println("Please enter a letter: ");
			String letter = in.nextLine();
			if (!usedLetter.contains(letter)){
				usedLetter.add(letter);
				this.wordFamily.generateFamily(this.dictionary.available, letter);
			}
			System.out.print("result: ");
			this.updateDictionary();
			System.out.println("List of letters entered: ");
			this.printList();
			System.out.println("Number of guess available: " + guess);
			
			
			System.out.println("Do you want to check how many possible words left Y/N: ");
			if (in.nextLine().equals("Y")){
				System.out.println(this.dictionary.available.size());
			}

		}
		
		if (this.wordCount == this.wordLength){
			System.out.println("Congratulations, you are amazing");
		} else {
			System.out.println("Sorry this is the word: " + this.dictionary.available.get(0));
		}
		
		in.close();
	}
	
	
	/*
	 * update the available word list based on the letter entered by user
	 * the list is generated from the longest list at wordFamily
	 */
	private void updateDictionary(){
		Set<String> listOfWords = this.wordFamily.family.keySet();
		Iterator<String> iterator = listOfWords.iterator();
		int maxWords = 0;
		String maxKey = null;
		// iterate through the list of key and check the length of each list
		while (iterator.hasNext()){
			String tempKey = (String) iterator.next();
			if (this.wordFamily.family.get(tempKey).size() > maxWords){
				maxWords = wordFamily.family.get(tempKey).size();
				maxKey = tempKey;
			}
		}
		//update number of guess if word family does not contain the letter
		if (maxKey.equals("Zero")){
			guess--;
		} 
		this.dictionary.available = wordFamily.family.get(maxKey);
		ArrayList<Integer> indexList = this.wordFamily.readKey(maxKey);
	
		for (int i = 0; i < this.wordLength; i++){
			if(indexList.contains(i)){
				word.setCharAt(i, maxKey.charAt(0));
				this.wordCount++;
			} 
		}
		System.out.println(word);
	}
	
	/*
	 *  print the list of letters that has been used
	 */
	private void printList(){
		for (int i = 0; i < usedLetter.size()-1; i++){
			System.out.print(usedLetter.get(i) + ", ");
		}
		System.out.print(usedLetter.get(usedLetter.size()-1));
		System.out.println();
	}
	
}
