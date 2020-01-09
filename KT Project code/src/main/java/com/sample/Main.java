package com.sample;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import com.sample.Question;
import com.sample.Recipe;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class Main {

    public static final void main(String[] args) {
    	//ask questions
    	askQuestions();
    	
    	//fire all rules
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
        	Recipe r = new Recipe();
        	ArrayList<Recipe> recipes = r.init();
            kSession.insert(recipes);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        //results
        
    }
    
    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void askQuestions(){
    	//make question list
    	Question q = new Question();
    	ArrayList<Question> questions = q.initQuestions();
    	
    	//ask questions
    	int k = 0;
    	Scanner scanner = new Scanner(System.in);
    	for(int i = 0;i < questions.size();i++){
    		//read question and possible answers
    		Question question = questions.get(i);
    		ArrayList<String> answers = question.getAnswers();
    		//print question
    		System.out.println(question.getQuestion());
    		if(question.isMultipleChoice() == true){
    			System.out.println("(Meerdere antwoorden mogelijk, plaats komma's tussen antwoorden)");
    		}
    		//print answers
    		for(int j = 0;j < answers.size();j++){
    			if( !(i == 5 && questions.get(5).getChosenAnswer() == j) ){
    				System.out.println( (j+1) + ") " + answers.get(j) );
    			}
    		}
    		//scan chosen answer
    		int chosenAnswer = 0;
    		ArrayList<Integer> outputAnswers = new ArrayList<Integer>();
    		while(scanner.hasNext()){
    			String output = scanner.nextLine();
    			if(isInteger(output) && question.isMultipleChoice() == false){
    				//single choice question
    				chosenAnswer = Integer.parseInt(output);
    				if(chosenAnswer > 0 && chosenAnswer <= answers.size()){
    					if (i == 3 && chosenAnswer >= 10) {
    						i = i + 2;
    					}
    					if(i == 4 && chosenAnswer == 2) {
    						i++;
    					}
    					if (i == 6 && chosenAnswer == 2) {
    						i++;
        				}
    					if (i == 10 && chosenAnswer != 5) {
    						i++;
    					}
    					if (i== 14 && chosenAnswer == 2) {
    						i++;
    					}
    					if (i == 3) {
    						//recipe.addVegetables(chosenAnswer);
    					}
    					break;
    				}
    			} else if (question.isMultipleChoice() == true) {
    				//multiple choice question
    				
    				//get multiple strings from input
    				ArrayList<String> outputList = new ArrayList<String>();
    				String ans = "";
    				for(int j = 0;j < output.length();j++){
    					Character c = output.charAt(j);
    					if( c == ',' ){
    						outputList.add(ans);
    						ans = "";
    					} else if ( j == (output.length() - 1) ) {
    						ans += c;
    						outputList.add(ans);
    						ans = "";
    					} else {
    						ans += c;
    					}
    				}
    				
    				//check if strings are integers
    				boolean validAnswers = true;
    				for(int j = 0;j < outputList.size();j++){
    					ans = outputList.get(j);
    					if(isInteger(ans)){
    						chosenAnswer = Integer.parseInt(ans);
    						if(chosenAnswer >= 1 && chosenAnswer <= question.getAnswers().size()){
        						outputAnswers.add(chosenAnswer);
    						} else {
    							validAnswers = false;
    						}
    					} else {
    						validAnswers = false;
    					}
    				}
    				
    				//act accordingly if strings are integers
    				if(validAnswers == true){
    					System.out.println("Zijn dit de antwoorden die je gekozen hebt?");
    					for(int j = 0;j < outputAnswers.size();j++){
    						System.out.println("- " + answers.get(outputAnswers.get(j) - 1));
    					}
    					System.out.println("1) Ja");
    					System.out.println("2) Nee");
    					int checkAnswerNumber = 0;
    					while(scanner.hasNext()){
    						String checkAnswer = scanner.nextLine();
    						if(isInteger(checkAnswer)){
    							checkAnswerNumber = Integer.parseInt(checkAnswer);
    							if(checkAnswerNumber == 1 || checkAnswerNumber == 2){
    								break;
    							}
    						}
    					}
    					if(checkAnswerNumber == 1){
    						break;
    					} else {
    						System.out.println("Geef je nieuwe keuze:");
    					}
    				}
    			}
    		}
    		//return answers to question
    		if(question.isMultipleChoice()){
    			question.setChosenAnswers(outputAnswers);
    		} else {
    			question.setChosenAnswer(chosenAnswer);
    		}
    		question.setQuestionAnswered(true);
    	}
    	scanner.close();
    	
    	q.printAnsweredQuestions(questions);
    }

}