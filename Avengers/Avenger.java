package Avengers;
import java.util.Comparator;
/** 
 * COMP 2503 Winter 2023 Assignment 1 
 * 
 * This method generates Avenger objects and how many times they have been mentioned during the lifespan of this object.
 *
 * @author Raphael Khan, Aulphrine Sagudan, Helga Shu Azinwi
*/

public class Avenger implements Comparable <Avenger>
{
	private int count=0;
	private String alias ="";
	private String name ="";	
/**
 * 
 * The Constructor, take note, there are no setters as I do not want people having access to change the info after it is already set.
 * @param aliasInput the alias to be assigned
 * @param nameInput the name to be assigned
 */

	public Avenger(String aliasInput, String nameInput)
	{
		count = 1;
		alias=aliasInput;
		name=nameInput;
	}

	/**Inline class comparing two Avengers by their rankings(Putting the highest ranked ones first), then their aliases alphabetically
	 * 
	 * 
	 */
	public static Comparator<Avenger> avengerTopRanking = new Comparator<Avenger>()
	{
	/**The method comparing two Avengers by their rankings(Putting the highest ranked ones first), then their aliases alphabetically
	 * @param a1 the First Avenger being compared
	 * @param a2 the Second Avenger being compared
	 * @return returns which Avenger to be sorted before the other in the ArrayList.
	 */
		public int compare(Avenger a1, Avenger a2)
		{	
			if(a1.getCount()==a2.getCount())
			{
				return a1.getAlias().compareTo(a2.getAlias());
			}
			else{
				return a2.getCount()-a1.getCount();
			}
		}
	};
	/**Inline class comparing two Avengers by their rankings(Putting the highest ranked ones first), then their names by length, then alhabetically by name
	 * 
	 * 
	 */
	public static Comparator<Avenger> avengerBottomRanking = new Comparator<Avenger>(){
	/**The method comparing two Avengers by their rankings(Putting the lowest ranked ones first), then their names by length, then their names alphabetically
	 * @param a1 the First Avenger being compared
	 * @param a2 the Second Avenger being compared
	 * @return returns which Avenger to be sorted before the other in the ArrayList.
	 */
		public int compare(Avenger a1, Avenger a2){
			
			if(a1.getCount() == a2.getCount())
			{
				if(a1.getName().length() == a2.getName().length()){
					return a1.getName().compareTo(a2.getName());

				}
				else{
					return a1.getName().length() - a2.getName().length();
				}
			}
			else{

				return a1.getCount() - a2.getCount();
			}
		}
	};
	
	/**
	 * This method just increases the count field of an Avenger object by one. I opted to not include a "setQuantity" method as it was not necessary
	 * 
	 */

	public void addQuantity()
	{
		count++;
	}
	/**
	 * Compares this instance of an Avenger to another, natural ordering is based on alphabetical ordering of alias.
	 * @return negative integer if this avenger is after the other, positive if it is before.
	 * 
	 */
	@Override
	public int compareTo(Avenger o)
	{
		
		return this.alias.compareTo(o.getAlias());
	}
	/**
	 * Accesses the name field
	 * 
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Accesses the count field
	 * @return the current count
	 */
	public int getCount()
	{
		return count;
	}
	/**
	 * Accesses the alias field
	 * @return the alias
	 */
	public String getAlias()
	{
		return alias;
	}
	
	
	/**
	 * This method checks a string to see if it matches either the alias or the name
	 * 
	 * @param a the string to be compared
	 * @return a boolean checking if it equals the name or the alias
	 */
	public boolean equals(Object a) 
	{
		return(this.name.equals(a) || this.alias.equals(a));	
	}
	
	/**
	 * returns a string containing all the fields in the format specified by the assignment.
	 * @return the string
	 */
	@Override
	public String toString() 
	{
		return alias + " aka " + name + " mentioned " + count + " time(s)";	
	}
}
