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
 * 
 * Modified 20171114 by Ian De Silva -- Updated to adhere to coding standards.
 * 
 */
package edu.ncsu.csc326.coffeemaker;
import static edu.ncsu.csc326.coffeemaker.CoffeeMakerUI.Mode.ADD_RECIPE;
import static edu.ncsu.csc326.coffeemaker.CoffeeMakerUI.Mode.WAITING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import edu.ncsu.csc326.coffeemaker.CoffeeMaker;
import edu.ncsu.csc326.coffeemaker.UICmd.ChooseRecipe;
import edu.ncsu.csc326.coffeemaker.UICmd.ChooseService;
import edu.ncsu.csc326.coffeemaker.UICmd.DescribeRecipe;

/**
 * Contains the step definitions for the cucumber tests.  This parses the 
 * Gherkin steps and translates them into meaningful test steps.
 *
 * ChooseService: эта команда позволяет пользователю выбрать, какую службу кофеварки использовать. Он меняет режим системы.
 *
 * DescribeRecipe: эта команда позволяет пользователю описать рецепт (используется в режимах EditRecipe и AddRecipe).
 *
 * ChooseRecipe: эта команда позволяет пользователю выбрать рецепт (используется в режимах ChooseRecipe и DeleteRecipe).
 *
 * InsertMoney: эта команда позволяет пользователю вставить деньги в автомат.
 *
 * Сброс: эта команда прерывает текущую команду и возвращается в состояние ожидания.
 *
 * CheckInventory: эта команда сохраняет текущий инвентарь в виде строки, доступной из команды
 *
 * AddInventory: эта команда позволяет пользователю добавлять инвентарь в систему.
 *
 * TakeMoneyFromTray: эта (несколько вымышленная) команда позволяет пользователю извлекать деньги из лотка возврата монет, куда после покупки кладутся дополнительные деньги.
 */
public class TestSteps {
	
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	private Inventory testInventory;
	private CoffeeMakerUI coffeeMakerMain; 
	private CoffeeMaker coffeeMaker;
	private RecipeBook recipeBook;

	
	private void initialize() {
		recipeBook = new RecipeBook();
		coffeeMaker = new CoffeeMaker(recipeBook, testInventory);
		coffeeMakerMain = new CoffeeMakerUI(coffeeMaker);
	}


	//Add a Recipe -------------------------------
    @Given("^coffee machine included with blank recipe book$")
    public void an_empty_recipe_book() throws Throwable {
        initialize();

        assertEquals(CoffeeMakerUI.Mode.WAITING,coffeeMakerMain.getMode());

    }
    @Then("^click the service add a recipe$")
	public void click_The_Service_Add_A_Recipe() throws Throwable {
		ChooseService chooseService = new ChooseService(1);
		coffeeMakerMain.UI_Input(chooseService);

		assertEquals(ADD_RECIPE,coffeeMakerMain.getMode());
		assertEquals(CoffeeMakerUI.Status.OK,coffeeMakerMain.getStatus());
	}

	@And("^add the recipe$")
	public void add_The_Recipe() throws Throwable {
		//coffeeMakerMain.coffeeMaker.addRecipe(recipe1);
		DescribeRecipe describeRecipe = new DescribeRecipe(recipe1);

		assertEquals(WAITING, coffeeMakerMain.getMode());
	}
/*
	@And("^choose a recipe$")
	public void choose_A_recipe() throws Throwable {
		ChooseRecipe chooseRecipe = new ChooseRecipe(0);

		assertEquals(WAITING, coffeeMakerMain.getMode());
	}
*/
	//End Add a Recipe--------------------------------------------

    @Given("a default recipe book")
	public void a_default_recipe_book() throws Throwable {
    	initialize();
    	
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for r5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		recipeBook.addRecipe(recipe1);
		recipeBook.addRecipe(recipe2);
		recipeBook.addRecipe(recipe3);
		recipeBook.addRecipe(recipe4);
		
	}
    
}
