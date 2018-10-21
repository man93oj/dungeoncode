import java.util.*;
public class Character
{
  private String name;
  private int PlayerID;
  private int score;
  private int currentPlaceID;
  
  private static Vector<Character> characters = new Vector<Character>();
  private static  HashMap< Integer, Character> mapCharacters = new HashMap<>(); 
  
  //Constructor for creating Character
  public Character( String Name, int id, int points, int startingPosition)
  {
    name = Name;
    PlayerID = id;
    score = points;
    characters.add(this);
    mapCharacters.put(PlayerID,this);
    currentPlaceID = startingPosition;
    Place.getPlaceById(currentPlaceID).addCharacter(this);
    return;
  }//end of Character constructor
  
  public Character( String Name, int id, int points)
  {
    name = Name;
    PlayerID = id;
    score = points;
    characters.add(this);
    mapCharacters.put(PlayerID,this);
    //currentPlaceID = startingPosition;
    //Place.getPlaceById(currentPlaceID).addCharacter(this);
    return;
  }//end of Character constructor
  
  //Getters and setter for functions
  public String getName()
  {
    return name;
  }
  public int getID()
  {
    return PlayerID;
  }
  public int getScore()
  {
    return score;
  }
  
  public void debugPrint()
  {
    System.out.println("Name for Player " + PlayerID + " is " + name + " and score is " + score + ". ");
    //System.out.println(Place.getPlaceById(currentPlaceID).getName() );
  }
  
  public int updateScore( int update)
  {
	  return score+update;
  }
//  public void staticPrint()
//  {	  
//	  
//  }// end of staticPrint() method
}//end of Character class