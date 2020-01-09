package com.sample;

import java.util.ArrayList;

public class Question {
	//Question expressed in a text string
	private String question;
	//Possible answers for this question
	private ArrayList<String> answers;
	//Whether the question has multiple choice answers
	private boolean isMultipleChoice;
	//Array of multiple chosen answers
	private ArrayList<Integer> chosenAnswers;
	//Single chosen answer
	private int chosenAnswer;
	//Weight of the question
	private int weight;
	//Is the question answered?
	private boolean isQuestionAnswered;
	
	public Question(){
		weight = 0;
		answers = new ArrayList<String>();
		isMultipleChoice = false;
		chosenAnswers = new ArrayList<Integer>();
		isQuestionAnswered = false;
	}
	
	/*
	 * Getters and setters
	 */
	public String getQuestion(){
		return question;
	}
	
	public void setQuestion(String question){
		this.question = question;
	}
	
	public ArrayList<String> getAnswers(){
		return answers;
	}
	
	public void addAnswer(String answer){
		this.answers.add(answer);
	}
	
	public boolean isMultipleChoice(){
		return isMultipleChoice;
	}
	
	public void setToMultipleChoice(boolean b){
		this.isMultipleChoice = b;
	}
	
	public ArrayList<Integer> getChosenAnswers(){
		return chosenAnswers;
	}
	
	public void setChosenAnswers(ArrayList<Integer> chosenAnswers){
		this.chosenAnswers = chosenAnswers;
	}
	
	public int getChosenAnswer(){
		return chosenAnswer;
	}
	
	public void setChosenAnswer(int chosenAnswer){
		this.chosenAnswer = chosenAnswer;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	public boolean isQuestionAnswered(){
		return isQuestionAnswered;
	}
	
	public void setQuestionAnswered(boolean b){
		this.isQuestionAnswered = b;
	}
	/*
	 * Initialize questions
	 */
	
	public ArrayList<Question> initQuestions(){
		ArrayList<Question> questions = new ArrayList<Question>();
    	Question q;
    	//make questions
    	q = new Question();
    	q.setWeight(2);
    	q.setQuestion("Wat is je favoriete keuken?");
    	q.addAnswer("Hollandse pot");
    	q.addAnswer("Italiaanse keuken");
    	q.addAnswer("Spaanse keuken");
    	q.addAnswer("Mexicaanse keuken");
    	q.addAnswer("Indiase keuken");
    	q.addAnswer("Indonesische keuken");
    	q.addAnswer("Thaise keuken");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(2);
    	q.setQuestion("Hou je van pittig eten?");
    	q.addAnswer("Ik kan totaal niet tegen pittig eten");
    	q.addAnswer("Ik hou van gematigd pittig eten");
    	q.addAnswer("Ik kan goed tegen pittig eten");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(3);
    	q.setQuestion("Ben je bereid om nieuwe dingen te proberen?");
    	q.addAnswer("Ja");
    	q.addAnswer("Nee");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(1);
    	q.setQuestion("Welke groente ben je momenteel het meest in ge\u00EFnteresseerd?");
    	q.addAnswer("Wortel");
    	q.addAnswer("Tomaat");
    	q.addAnswer("Paprika");
    	q.addAnswer("Paddestoelen");
    	q.addAnswer("Kool");
    	q.addAnswer("Bladgroenten");
    	q.addAnswer("Bonen");
    	q.addAnswer("Broccoli");
    	q.addAnswer("Spinazie");
    	q.addAnswer("Ik eet geen groenten");
    	q.addAnswer("Ik hou van alle groenten");
    	questions.add(q);
    	
    	//Optionele vraag: Vraag niet stellen als antwoord op vraag Wat is je favoriete groente? = �Ik hou van alle groenten�
    	
    	q = new Question();
    	q.setQuestion("Zijn er groenten die je niet lust?");
    	q.addAnswer("Ja");
    	q.addAnswer("Nee");
    	questions.add(q);
    			
    	//Wanneer antwoord op vraag zijn er groenten die je niet lust? ja is.
    	//Welke groente lust je niet? (Repeaten totdat �Ik lust alle bovenstaande groenten�)
    	q = new Question();
    	q.setWeight(2);
    	q.setToMultipleChoice(true);
    	q.setQuestion("Welke groente lust je niet?");
    	q.addAnswer("Wortel");
    	q.addAnswer("Tomaat");
    	q.addAnswer("Paprika");
    	q.addAnswer("Paddestoelen");
    	q.addAnswer("Kool");
    	q.addAnswer("Bladgroenten");
    	q.addAnswer("Bonen");
    	q.addAnswer("Broccoli");
    	q.addAnswer("Spinazie");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(2);
    	q.setQuestion("Hou je van fruit in avondmaaltijden?");
    	q.addAnswer("Ja");
    	q.addAnswer("Nee");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(1);
        q.setQuestion("Welk fruit ben je momenteel het meest in ge\u00EFnteresseerd?");
        q.addAnswer("Appel");
        q.addAnswer("Aardbei");
        q.addAnswer("Ananas");
        q.addAnswer("Banaan");
        q.addAnswer("Bessen");
        q.addAnswer("Kiwi");
        q.addAnswer("Mango");
        q.addAnswer("Sinaasappel");
        q.addAnswer("Perzik");
        q.addAnswer("Gedroogd fruit(denk aan rozijnen of abrikozen)");
        q.addAnswer("Ik houd van al het fruit");
        questions.add(q);
    	
    	//Optionele vraag Vraag alleen stellen als antwoord op vorige vraag = �ja� of �geen voorkeur�
    	//OF 
    	//Antwoord op vorige vraag = �nee� && je wilt nieuwe dingen proberen

    	//Wat is je favoriete fruit
    	
    	q = new Question();
    	q.setWeight(2);
    	q.setQuestion("Waar ga je boodschappen doen?");
    	q.addAnswer("Grote Supermarkt");
    	q.addAnswer("Kleine lokale supermakrt");
    	q.addAnswer("De markt");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(3);
    	q.setQuestion("Heb je een oven?");
    	q.addAnswer("Ja");
    	q.addAnswer("Nee");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(3);
    	q.setQuestion("Gaat je voorkeur uit naar kip, varken, rundvlees, vis, vegetarisch, of heb je geen voorkeur?");
    	q.addAnswer("Kip");
    	q.addAnswer("Varkensvlees");
    	q.addAnswer("Rundvlees");
    	q.addAnswer("Vis");
    	q.addAnswer("Vegetarisch");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	//Optionele vraag Wanneer antwoord = vegetarisch
    	
    	q = new Question();
    	q.setWeight(2);
    	q.setQuestion("Wil je vleesvervangers gebruiken of gaat je voorkeur uit naar een origineel vegetarisch gerecht?");
    	q.addAnswer("Origineel vegetarisch gerecht");
    	q.addAnswer("Vleesvervangers");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(3);
    	q.setQuestion("Wil je warm of koud eten? ");
    	q.addAnswer("Warm");
    	q.addAnswer("Koud");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(3);
    	q.setQuestion("Hoeveel tijd wil je besteden aan het bereiden?");
    	q.addAnswer("0-30 minuten");
    	q.addAnswer("30-60 minuten");
    	q.addAnswer("Meer dan 60 minuten");
    	q.addAnswer("Geen voorkeur");
    	questions.add(q);
    	
    	q = new Question();
    	q.setWeight(0);
    	q.setQuestion("Heb je allergiën?");
    	q.addAnswer("Ja");
    	q.addAnswer("Nee");
    	questions.add(q);
    	
    	//Optionele vraag, alleen wanneer antwoord op vorige vraag ja is.
    	
    	q = new Question();
    	q.setWeight(3);
    	q.setToMultipleChoice(true);
    	q.setQuestion("Ben je allergisch voor een van de onderstaande ingredi\u00EBnten?");
    	q.addAnswer("Granen");
    	q.addAnswer("Vis en schaaldieren");
    	q.addAnswer("Eieren");
    	q.addAnswer("Pinda's");
    	q.addAnswer("Soya");
    	q.addAnswer("Melk");
    	q.addAnswer("Noten");
    	q.addAnswer("Mosterd");
    	q.addAnswer("Fruit");
    	q.addAnswer("Sesamzaad");
    	questions.add(q);
    	
    	return questions;
	}
	
	public void printAnsweredQuestions(ArrayList<Question> questions){
		System.out.println("Vraag en antwoorden:");
		for(int i = 0;i < questions.size();i++){
			Question q = questions.get(i);
			if(q.isQuestionAnswered()){
				System.out.println(q.getQuestion());
				ArrayList<String> answers = q.getAnswers();
				if(q.isMultipleChoice()){
					ArrayList<Integer> chosenAnswers = q.getChosenAnswers();
					for(int j = 0;j < answers.size();j++){
						for(int k = 0;k < chosenAnswers.size();k++){
							if(j+1 == chosenAnswers.get(k)){
								System.out.println("- " + answers.get(j));
							}
						}
					}
				} else {
					for(int j = 0;j < answers.size();j++){
						if(j+1 == q.getChosenAnswer()){
							System.out.println("- " + answers.get(j));
						}
					}
				}
				System.out.println("");
			}
		}
	}
}
