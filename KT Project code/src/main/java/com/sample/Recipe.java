package com.sample;

import java.util.ArrayList;

public class Recipe {
	private String name;
    //Time is given in minutes
    private int time;
    // 1: Hollandse pot
    // 2: Italian cuisine
    // 3: Spanish cuisine
    // 4: Mexican cuisine
    // 5: Indian cuisine
    // 6: Indonesian cuisine
    // 7: Thai cuisine
	private int cuisine;
	private ArrayList<Integer> vegetables = new ArrayList<Integer>();
	private ArrayList<Integer> fruits;
	private ArrayList<Integer> meat;
	// 1: Not spicy
	// 2: Medium spicy
	// 3: Very spicy
    private int spicy;
	private boolean oven;
	private boolean vegetarian;
	private boolean coldMeal;
	
	/*
	 * Getters and setters
	 */
	public int cuisine() {
        return this.cuisine;
    }
	
    public void setCuisine(int cuisine){
    	this.cuisine = cuisine;
    }
    
    public ArrayList<Integer> vegetables(){
		return this.vegetables;
	}
	
	public void addVegetables(int vegetable){
		this.vegetables.add(vegetable);
	}
	public ArrayList<Integer> fruits(){
		return this.fruits;
	}
	
	public void addFruits(int fruits){
		this.fruits.add(fruits);
	}
	public ArrayList<Integer> meat(){
		return this.meat;
	}
	
	public void addMeat(int meat){
		this.meat.add(meat);
	}
    
    public int spicy() {
        return this.spicy;
    }
    public void setSpicy(int spicy) {
        this.spicy = spicy;
    }
    
    /*
     * Initialize recipes
     */
    public ArrayList<Recipe> init(){
    	ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    	
    	return recipes;
    }
}
