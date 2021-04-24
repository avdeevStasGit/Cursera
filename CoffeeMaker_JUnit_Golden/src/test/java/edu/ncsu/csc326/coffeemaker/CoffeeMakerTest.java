package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;
    private Inventory inventory;

    private RecipeBook recipeBook;
    private Recipe recipe0;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;

    @Before
    public void setUp() throws Exception {
        coffeeMaker = new CoffeeMaker();
        inventory = new Inventory();
        recipeBook = new RecipeBook();

        recipe0 = new Recipe();
        recipe0.setName("Coffee");
        recipe0.setAmtChocolate("0");
        recipe0.setAmtCoffee("3");
        recipe0.setAmtMilk("1");
        recipe0.setAmtSugar("1");
        recipe0.setPrice("50");

        recipe1 = new Recipe();
        recipe1.setName("Mocha");
        recipe1.setAmtChocolate("20");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("1");
        recipe1.setAmtSugar("1");
        recipe1.setPrice("75");

        recipe2 = new Recipe();
        recipe2.setName("Latte");
        recipe2.setAmtChocolate("0");
        recipe2.setAmtCoffee("3");
        recipe2.setAmtMilk("3");
        recipe2.setAmtSugar("1");
        recipe2.setPrice("100");

        recipe3 = new Recipe();
        recipe3.setName("Hot Chocolate");
        recipe3.setAmtChocolate("4");
        recipe3.setAmtCoffee("0");
        recipe3.setAmtMilk("1");
        recipe3.setAmtSugar("1");
        recipe3.setPrice("65");
    }

    @Test
    public void addRecipe() {
    }

    @Test
    public void deleteRecipe() {
    }

    @Test
    public void editRecipe() {
    }

    //--------------------------------------------------
    //testInventory
    //--------------------------------------------------

    @Test
    public void testAddInventory() throws InventoryException {
        coffeeMaker.addInventory("5", "8", "0", "8");
    }
    //Если пользователь вводит буквенный символ, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException1() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "asdf", "3");
    }
    //Если пользователь выбирает отрицательное или не целое число, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException2() throws InventoryException {
        coffeeMaker.addInventory("4", "-5", "3", "3");
    }

    //Если пользователь выбирает отрицательное или не целое число, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException3() throws InventoryException {
        coffeeMaker.addInventory("4", "5.0", "3", "3");
    }
    //--------------------------------------------------
    //testInventory
    //--------------------------------------------------

    @Test
    public void checkInventory() {
    }



    @Test
    public void makeCoffee() {
    }

    @Test
    public void getRecipes() {
    }
}