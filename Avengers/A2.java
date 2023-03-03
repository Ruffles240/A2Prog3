package Avengers;

import java.util.Scanner;

/** 
 * COMP 2503 Winter 2020 Assignment 2 
 * 
 * This program must read a input stream and keeps track of the 
 * frequency at which an avenger is mentioned either by name or alias.
 *
 * @author Maryam Elahi
 * @date Fall 2020
*/
public class A2 {
	
	public String[][] avengerRoster = { { "captainamerica", "rogers" }, { "ironman", "stark" },
			{ "blackwidow", "romanoff" }, { "hulk", "banner" }, { "blackpanther", "tchalla" }, { "thor", "odinson" },
			{ "hawkeye", "barton" }, { "warmachine", "rhodes" }, { "spiderman", "parker" },
			{ "wintersoldier", "barnes" } };

	private int topN = 4;
	private int totalwordcount = 0;
	//private SLL<Avenger> mentionList = new SLL<Avenger>();
	//private SLL<Avenger> alphabticalList = new SLL<Avenger>();
	//private SLL<Avenger> mostPopularList = new SLL<Avenger>(new AvengerComparatorFreqDesc());
	//private SLL<Avenger> leastPopularList = new SLL<Avenger>(new AvengerComparatorFreqAsc());
	public SLL<Avenger> avengersList= new SLL<Avenger>();
	public SLL<Avenger> sortedTop;
	public SLL<Avenger> sortedBottom;
	public SLL<Avenger> sortedAlpha;
	
	/**
	 * This is the main method 
	 * @param args
	 */
	public static void main(String[] args) {
		A2 a1 = new A2();
		a1.run();
	}
	
	/**
	 * run method 
	 */
	public void run() {
		readInput();
		createdOrderedLists();
		printResults();
	}
	
	/**
	 * This method creates the list 
	 */
	private void createdOrderedLists() {
		// TODO: 
		sortedBottom = avengersList.sort(Avenger.avengerBottomRanking);
		sortedTop = avengersList.sort(Avenger.avengerTopRanking);
		sortedAlpha = avengersList.sort();
	}

	/**
	 * read the input stream and keep track  
	 * how many times avenger are mentioned by alias or last name.
	 */
	private void readInput() {
		Scanner input = new Scanner(System.in);
		/*
		In a loop, while the scanner object has not reached end of stream,
		 	- read a word.
		 	- clean up the word
		    - if the word is not empty, add the word count. 
		    - Check if the word is either an avenger alias or last name then
				- Create a new avenger object with the corresponding alias and last name.
				- if this avenger has already been mentioned, increase the frequency count for the object already in the list.
				- if this avenger has not been mentioned before, add the newly created avenger to the end of the list, remember to set the frequency.
		*/ 
		
		while (input.hasNext()) {
			String word = cleanWord(input.next());
			if (word.length() > 0) {
				totalwordcount++;
				for(String [] avenger:avengerRoster)
				{
						if(avenger[0].equals(word)||avenger[1].equals(word))
						{											
							Node<Avenger> searched = avengersList.search(avenger[0]);                           
							if(searched==null)
							{
								Avenger newAvenger = new Avenger(avenger[0],avenger[1]);
								avengersList.add(newAvenger);
								break;
							}			
							else{
								searched.getData().addQuantity();
								break;
							}
						}				
				}
			}
		}
	}
	
	/**
	 * This method cleans up the words ( removing apostrophe and strings, 
	 * convert all the words to lower case, eliminate all punctuations and numbers)
	 * Accepts @param next
	 * And @return ret (the cleaned up word)
	 */
	private String cleanWord(String next) {
		// First, if there is an apostrophe, the substring
		// before the apostrophe is used and the rest is ignored.
		// Words are converted to all lowercase.
		// All other punctuation and numbers are skipped.
		String ret;
		ret = next.trim().split("'")[0];
		ret = ret.toLowerCase().replaceAll("[^a-zA-Z]", "");
		return ret;
	}
	

	/**
	 * print the results
	 */
	private void printResults() {
		// Todo: Print the list of avengers in the order they appeared in the input
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + avengersList.size());
		System.out.println();
		System.out.println("All avengers in the order they appeared in the input stream:");
		
		Node<Avenger> pointer = avengersList.getHead();
		
		while(pointer!=null) {
			System.out.println(pointer.getData());
			pointer=pointer.getNext();
		}
		System.out.println();
		
		// Todo: Print the most popular avengers, see the instructions for tie breaking
		System.out.println("Top " + topN + " most popular avengers:");
		pointer = sortedTop.getHead();
		int index = 0;
		
		while(pointer!=null && index < 4) {
			System.out.println(pointer.getData());
			pointer=pointer.getNext();
			index++;
		}
		System.out.println();
		
		// Todo: Print the least popular avengers, see the instructions for tie breaking
		System.out.println("Top " + topN + " least popular avengers:");
		
		pointer = sortedBottom.getHead();
		index = 0;
		
		while(pointer!=null && index < 4) { 
			System.out.println(pointer.getData());
			pointer=pointer.getNext();
			index++;
		}
		System.out.println();

		// Todo: Print the list of avengers in alphabetical order
		System.out.println("All mentioned avengers in alphabetical order:");
		
		pointer = sortedAlpha.getHead();
		
		while(pointer!=null) {
			System.out.println(pointer.getData());
			pointer=pointer.getNext();
		}
		System.out.println();
	}
}
