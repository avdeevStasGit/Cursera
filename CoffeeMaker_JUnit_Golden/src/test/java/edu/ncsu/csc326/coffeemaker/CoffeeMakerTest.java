package edu.ncsu.csc326.coffeemaker;

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

    @Test
    public void addInventory() {
    }

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