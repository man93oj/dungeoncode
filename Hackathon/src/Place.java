import java.util.*;
public class Place
{
  private String name = "";
  private int ID;
  //Static collection of Places
//Adding static collection of things to the class
	private static Vector<Place> places = new Vector<Place>();
	private static  HashMap< Integer, Place> mapPlaces = new HashMap<>();
  
	private Vector<Character> characters = new Vector<>(); 
  //Constructor for the Place class
  public Place( String Name, int id)
  { 
	  name = Name;
	  ID = id;
	  places.add(this);
	  mapPlaces.put( ID, this);
  }//end of the constructor
	
	public int getID()
	{
		return ID; 
	}
	
	public String getName()
	{
		return name; 
	}
	
	public static Place getPlaceById(int placeID)
	{
		Place usablePlace = null;
		if(mapPlaces.containsKey(placeID) ) {
		   usablePlace = mapPlaces.get(placeID);
		}//end of if statement;
		return usablePlace;
	}//end of getPlaceById method
	
	public void addCharacter( Character charac) 
	{
		characters.add(charac);
		return;
	}
	
	public void showCharacters()
	{
		for(Character c: characters)
		{
			System.out.println("Characters " + c.getName() );
		}
	}
}//end of Place 
