
import java.util.*;
import java.io.*;

public class Game
{
  
  
   /* Place EntranceHall = new Place();
    File file = new File("name.txt");
    //Scanner reader = new Scanner(new File("name.txt"));an
    Scanner reader = new Scanner(file);
    Scanner scan = new Scanner(System.in);
    String name;
    name = reader.nextLine();
    System.out.println(name);
    //Scanner scan = new Scanner(System.in);
    EntranceHall.print();
    */
    
    public Vector<Character> characters = new Vector();
    public Vector<Place> places = new Vector<>();
    public Vector<Questions> questions = new Vector<>();
    
    private String gameName;  
    public Game(String name)
    {
      gameName = name;
    }
    
    //Getting from user input
  public void play() throws IOException
  {
	  
	  //Create the dungeon with all the places
	  Place Entrance = new Place("Entrance", 0);
	  Place Level1 = new Place("Level 1", 1);
	  Place Level2 = new Place("Level 2", 2);
	  
	  places.add(Entrance); 
	  places.add(Level1); 
	  places.add(Level2); 
	  
    Scanner scan = new Scanner(System.in);
      int noOfCharacters = 0;
      String charName = "";
      int startingPosition = 0;
      while(true)
      {
        System.out.println("How many players are playing?");
        noOfCharacters = scan.nextInt();
        
        if( noOfCharacters > 4 || noOfCharacters < 0)
        {
          System.out.println("Invalid number of Players. Please enter a number between 0 and 4");
        }
        else 
        {
          break;
        }
      }//end of while loop to find total number of Players
      
      for(int i = 1; i<=noOfCharacters; i++)
        {
          System.out.println("Please enter the player's name");
          charName = scan.next();
//          System.out.println("Enter a starting position");
//          startingPosition = scan.nextInt();
          //Character newCharacter = new Character(charName, i, 0, startingPosition);
          Character newCharacter = new Character(charName, i, 0);
          characters.add(newCharacter);
        }//end of for loop
      
      
      System.out.println("\n\n\t***Begin***");
      System.out.println("Welcome players!\nI am the Dungeon Master and I will guide you through the dungeon of code.");
      System.out.println("Heed my words carefully or else you will be lost in the mysterious world of code. ");
      System.out.print("\n");
      
      Scanner questionScanner = new Scanner( new File("Questions4.txt"));
      String question = questionScanner.nextLine();
      int noOfQuestions = 0;
      if(question.contains("Questions"))
      {
      	 noOfQuestions = Integer.parseInt(question.substring(question.indexOf("Questions")+10, question.indexOf("//")).trim());
      	int q = 0;
    	while( q<noOfQuestions)
    	{
     		Questions quest = new Questions(questionScanner);		
    		 q++;
    	}//end of Direction while loop
      }//End of reading in a series of questions
      
      
      boolean gameStillGoing = true;
      
      while( gameStillGoing )
      {
    	  //for( int i = 0; i < characters.size(); i++)
    	  int i = 0;
    	  while( i < characters.size() )
    	  {
    		  String input;
    		  System.out.println("\nThis question will be for Player " + characters.elementAt(i).getID() );
    		  double randNum = (Math.random()* 4 + 1);

    		  boolean QuestionAskedChecker = false;
    		  QuestionAskedChecker = Questions.getQuestionById( (int)randNum ).getAsked();
    		  while( QuestionAskedChecker == true)
    		  {
    			  //randNum = (Math.random()* 4 + 1);
    			  randNum = (int)Math.random()*4 +1;

        		  QuestionAskedChecker = Questions.getQuestionById( (int)randNum ).getAsked();
        		 
    		  }//
    		  Questions.getQuestionById( (int)randNum).askQuestion();
    		  input = scan.next();
    		  if( input.equalsIgnoreCase( Questions.getQuestionById( (int)randNum ).getAnswer() ) )
    		  {
    			  System.out.println("Correct answer");
    			  characters.elementAt(i).updateScore(20);
    			  
    		  }
    		  else
    		  {
    			  System.out.println("Wrong answer");
    		  }
    		  System.out.println("Teaching explanation");
    		  System.out.println( Questions.getQuestionById( (int)randNum ).getExplanation() );
    		  Questions.getQuestionById( (int)randNum).changedQuestionAsked();
    		  
    		  if( (i+1) >=noOfQuestions  )
    		  {
    			  System.out.println( " Questions are done " );
    			  gameStillGoing = false;
    			  break;
    		  }
    		  i++;
    	  }
    	  gameStillGoing = false;
      }
      //Now to iterate through the different players and code
      
      int winnerId = 0;
      int maxScore = 0;
      for(int w = 0; w<characters.size(); w++)
      {
    	  if( maxScore < characters.elementAt(w).getScore())
    	  {
    		  winnerId = w;
    	  }
    	  
      }
      System.out.println("The winner of this game is Player " + (winnerId + 1) + " : " + characters.elementAt(winnerId).getName() );
      System.out.println("\n");
      scan.close();
      questionScanner.close();
  }//end of play method
   

}//end of Game classHa
