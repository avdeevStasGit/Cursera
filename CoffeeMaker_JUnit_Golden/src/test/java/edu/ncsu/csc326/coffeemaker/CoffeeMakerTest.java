package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Assert;
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
    //testInventoryStart
    //--------------------------------------------------

    @Test
    public void testAddInventory() throws InventoryException {
        coffeeMaker.addInventory("5", "8", "0", "8");
    }

    //Если пользователь вводит буквенный символ, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException11() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "asdf", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException12() throws InventoryException {
        coffeeMaker.addInventory("asdf", "5", "4", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException13() throws InventoryException {
        coffeeMaker.addInventory("4", "asdf", "4", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException14() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "4", "asdf");
    }

    //Если пользователь выбирает отрицательное или не целое число, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException21() throws InventoryException {
        coffeeMaker.addInventory("4", "-5", "3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException22() throws InventoryException {
        coffeeMaker.addInventory("-4", "5", "3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException23() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "-3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException24() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "3", "-3");
    }

    //Если пользователь выбирает отрицательное или не целое число, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException31() throws InventoryException {
        coffeeMaker.addInventory("4", "5.4", "3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException32() throws InventoryException {
        coffeeMaker.addInventory("4.0", "5.4", "3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException33() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "3.6", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException34() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "3", "3.7");
    }
    //--------------------------------------------------
    //testInventoryEnd
    //--------------------------------------------------

    // пользователю будет показан список ингредиентов в кофеварке.
    @Test
    public void checkInventory() {
        inventory.setMilk(10);
        inventory.setChocolate(10);
        inventory.setCoffee(10);
        inventory.setSugar(10);
        Assert.assertEquals("Coffee: 10\n" +
                "Milk: 10\n" +
                "Sugar: 10\n" +
                "Chocolate: 10\n" , coffeeMaker.checkInventory());
    }

    //Когда мы делаем кофе, выбираем действующий рецепт и платим больше, чем стоимость кофе. Сдача 25.
    @Test
    public void makeCoffee() {
        coffeeMaker.addRecipe(recipe0);
        assertEquals(25, coffeeMaker.makeCoffee(0, 75));

    }

    //Кофеварка проверит, достаточно ли ингредиентов в инвентаре для приготовления выбранного напитка.
    //Если запасов недостаточно для приготовления напитка, отобразится сообщение, деньги пользователя будут возвращены
    @Test
    public void makeCoffee1() {
        inventory.setMilk(1);
        inventory.setChocolate(1);
        inventory.setCoffee(1);
        inventory.setSugar(1);

        coffeeMaker.addRecipe(recipe0);
        assertEquals(50, coffeeMaker.makeCoffee(0, 50));

    }

    @Test
    public void getRecipes() {
    }
}