/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * Modifications
 * 20171113 - Michael W. Whalen - Extended with additional recipe.
 * 20171114 - Ian J. De Silva   - Updated to JUnit 4; fixed variable names.
 */
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;



/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 *
 * Extended by Mike Whalen
 */

public class CoffeeMakerTest {
	
	//-----------------------------------------------------------------------
	//	DATA MEMBERS
	//-----------------------------------------------------------------------
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
    private Inventory testInventory;
	private Recipe [] stubRecipies; 
	
	/**
	 * The coffee maker -- our object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	/**
	 * The stubbed recipe book.
	 */
	private RecipeBook recipeBookStub;
	
	
	//-----------------------------------------------------------------------
	//	Set-up / Tear-down
	//-----------------------------------------------------------------------
	/**
	 * Initializes some recipes to test with, creates the {@link CoffeeMaker} 
	 * object we wish to test, and stubs the {@link RecipeBook}. 
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		recipeBookStub = mock(RecipeBook.class);
		testInventory = new Inventory();
		coffeeMaker = new CoffeeMaker(recipeBookStub, testInventory);

		
		//Set up for recipe1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for recipe2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for recipe3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for recipe4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for recipe5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		stubRecipies = new Recipe [] {recipe1, recipe2, recipe3};



	}
	
	@Test
	public void test_Make_Coffee0() {
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertTrue(true);
	}

	//Основной поток: пользователь выбирает напиток, который желает приобрести.
	// Пользователь будет вносить деньги для оплаты напитка.
    @Test
    public void test_Make_Coffee() {
		// Определяем поведение
        when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);

        // Выбираем рецепт
        coffeeMaker.addRecipe(stubRecipies[0]);

        // Проверяем(вносим деньги для оплаты напитка)
        assertEquals(0, coffeeMaker.makeCoffee(0, 50));

    }

	//Кофеварка проверит, достаточно ли ингредиентов в инвентаре для приготовления выбранного напитка.
	//Создаем пустой инвентарь(testInventory)
	@Test
	public void test_Empty_Inventory_Make_Coffee() throws InventoryException {
		testInventory = new Inventory();
		testInventory.setCoffee(0);
		testInventory.setChocolate(0);
		testInventory.setMilk(0);
		testInventory.setSugar(0);

		coffeeMaker = new CoffeeMaker(recipeBookStub, testInventory);

		// Определяем поведение
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);

		// Выбираем рецепт
		coffeeMaker.addRecipe(recipe1);

		// Проверка при покупке с пустым инвентарем. Кофеварка должна вернуть всю сумму - 50.
		assertEquals(50, coffeeMaker.makeCoffee(0, 50));
	}

	// Внесение денег со сдачей
	@Test
	public void test_With_Delivery_Make_Coffee() {
		// Определяем поведение
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);

		// Выбираем рецепт
		coffeeMaker.addRecipe(stubRecipies[0]);

		// Проверяем. Сдача 25
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}

    // Если пользователь вводит недостаточно денег для покупки, деньги будут возвращены
	@Test
	public void test_Surrender_Make_Coffee() {
		// Определяем поведение
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);

		// Выбираем рецепт
		coffeeMaker.addRecipe(stubRecipies[0]);

		// Проверяем
		assertEquals(10, coffeeMaker.makeCoffee(0, 10));
	}

	// Если пользователь выберет номер, не соответствующий рецепту, деньги пользователя будут возвращены
	@Test
	public void test_Not_Matching_Number_Make_Coffee() {
		// Определяем поведение
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);

		// Проверяем
		assertEquals(70, coffeeMaker.makeCoffee(3, 70));
	}

	@Test
	public void test_Call3_Make_Coffee() {
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
		coffeeMaker.addRecipe(stubRecipies[0]);
		assertEquals(stubRecipies[0].getName(), "Coffee");
		assertEquals(stubRecipies[0].getAmtChocolate(), 0);
		assertEquals(stubRecipies[0].getAmtCoffee(), 3);
		assertEquals(stubRecipies[0].getAmtMilk(), 1);
		assertEquals(stubRecipies[0].getAmtSugar(), 1);
		assertEquals(stubRecipies[0].getPrice(), 50);
	}

	@Test
    public void test_igridient() {
        when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
	    coffeeMaker.makeCoffee(0,50);
        assertEquals(12,testInventory.getCoffee());
    }

    @Test
    public void test_igridient2() {
        when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);
        coffeeMaker.makeCoffee(0,50);
        assertEquals(14,testInventory.getSugar());
    }

}

