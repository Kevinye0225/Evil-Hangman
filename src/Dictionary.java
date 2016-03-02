import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
 * Read the dictionary file and store the list of words and available word length 
 * @author Kevin
 */
public class Dictionary {
	public HashSet<Integer> wordSize;
	public ArrayList<String> available;
	public ArrayList<String> original;
	private Scanner in;
	
	/*
	 * Constructor
	 */
	public Dictionary(){
		wordSize = new HashSet<Integer>();
		available = new ArrayList<String>();
		original = new ArrayList<String>();
		this.readFile();
		this.updateList();
	}
	
	/*
	 * reads the dictionary and populate the list
	 */
	private void readFile(){
		in = null;
		try {
			File inputFile = new File("dictionary.txt");
			in = new Scanner(inputFile);
			while (in.hasNextLine()){
				original.add(in.nextLine());
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		in.close();
	}
	
	/*
	 * Update list of available word length
	 */
	private void updateList(){
		for (int i = 0; i < original.size(); i++){
			wordSize.add(original.get(i).length());
		}
	}
	
	/*
	 * Update available based on word length entered by user
	 */
	public void updateWord(int length){
		for(int i = 0; i < this.original.size(); i++){
			if (original.get(i).length() == length){
				available.add(original.get(i));
			}
		}
	}
}
