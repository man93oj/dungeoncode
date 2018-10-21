import java.util.*;
import java.io.*;

public class Questions {
	private int QuestionIdNum;
	private String question;
	
	//private String answersChoices;
	//For Level 1 since it is a multiple choice level, use a vector 
	private Vector<String> answerChoices = new Vector<>(); 
	
	private String answer;
	private String teachingDescription;
	//private int LevelOfDifficulty;
	private boolean asked = false;
	
	//static usage of questions
	private static Vector<Questions> questions = new Vector<Questions>();
	private static  HashMap< Integer, Questions> mapQuestions = new HashMap<>();
	//Constructor of the question
	public Questions(int IdNum, String Questions, String AnswerChoicesA, String AnswerChoicesB, String AnswerChoicesC, 
						 String AnswerChoicesD, String ActualAnswer, String explanation)//, int difficultyLevel )
	{
		QuestionIdNum = IdNum;
		question = Questions;
		answerChoices.add(AnswerChoicesA);
		answerChoices.add(AnswerChoicesB);
		answerChoices.add(AnswerChoicesC);
		answerChoices.add(AnswerChoicesD);
		answer = ActualAnswer;
		teachingDescription = explanation;
		//LevelOfDifficulty = difficultyLevel;
		asked = false;
		questions.add(this);
		mapQuestions.put(QuestionIdNum, this);
		return;
	}
	
	
	//Constructor with scanner
	public Questions( Scanner scanner)
	{
		String line = "";
		boolean nextTemp = true;
		while( nextTemp)
		{
			if(line.split("//")[0].trim() == null || line.split("//")[0].trim().isEmpty() || (line.trim()).isEmpty()) {
				
          	  line = scanner.nextLine(); 
      			 continue; }
			else { nextTemp = false; break;}
		}//end of while loop
		int QuestionIdNum;
		String Questions; String AnswerChoicesA; String AnswerChoicesB; String AnswerChoicesC;
		String AnswerChoicesD; String ActualAnswer; String explanation = "";
		
		int nExplanationLines;
		QuestionIdNum = Integer.parseInt(line);
		Questions = scanner.nextLine();
		AnswerChoicesA = scanner.nextLine();
		AnswerChoicesB = scanner.nextLine();
		AnswerChoicesC = scanner.nextLine();
		AnswerChoicesD = scanner.nextLine();
		ActualAnswer   = scanner.nextLine();
		//line = scanner.nextLine();
		nExplanationLines  = Integer.parseInt(scanner.nextLine().trim());
//		for()
//		{
//			explanation    = scanner.nextLine();
//		}
		for(int d = 0; d < nExplanationLines; d++)
		{
		  line = scanner.nextLine();
   		   explanation += line;
   	       explanation += ".\n";
		}
		Questions questionObject = new Questions( QuestionIdNum, Questions,  AnswerChoicesA,  AnswerChoicesB,  AnswerChoicesC, 
				 									  AnswerChoicesD,  ActualAnswer,  explanation);
		
	}//end of Questions constructor
	
	public static Questions getQuestionById(int questionID)
	{
		Questions nextQuestion = null;
		if(mapQuestions.containsKey(questionID) ) {
		   nextQuestion = mapQuestions.get(questionID);
		}//end of if statement;
		return nextQuestion;
	}//end of getPlaceById method
	
	public String getAnswer()
	{
		return answer;
	}//get the actual Answer for the question
	
	public String getExplanation()
	{
		return teachingDescription;
	}//get the  explanation for the question
	
//	public void getExplanation()
//	{
//		System.out.println(teachingDescription);
//	}
	
	public void askQuestion()
	{
		System.out.println(question);

		for(int options = 0; options < answerChoices.size(); options++)
		{
			System.out.println(answerChoices.elementAt(options) + ".\n");
		}

		System.out.println("Please select the correct answer");
	}
	
}//end of Questions class
