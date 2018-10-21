
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) throws IOException 
 { 
	 			//Reading in the file
			//	Scanner reader = new Scanner(new File("MysticCity31.gdf")); 
			//	Game g = new Game(reader);
				
				Game g = new Game("Dungeon of Code");
				g.play();
			System.out.println("End"); 
			System.out.println(" You have exited the game" );
			
 }//end of main
}//end of Tester class