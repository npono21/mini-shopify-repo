package SYSC4806Project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    Main main;
    Buyer buyer;
    Merchant merchant;
    Shop shop;
    Product bread;
    Product toaster;

    @BeforeEach
    void setUp() {
        main = new Main();
        buyer = new Buyer("Rebecca", "ult1m4t3_fr1sb33", main);
        merchant = new Merchant("Arthur", "zinch", main);
        merchant.createShop("Arthur's Appliances", 123);
        toaster = new Product("Toaster", 12.99);
        bread = new Product("Bread", 4.25);
        shop = main.getShopByName("Arthur's Appliances");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addProduct() {
        // Add valid Product to Shop
        assertTrue(shop.addProduct(toaster));
        // Add duplicate valid Product to Shop
        assertTrue(shop.addProduct(toaster));
        // Add null Product to Shop
        assertFalse(shop.addProduct(null));
    }

    @Test
    void removeProduct() {
        // Add valid Product to Shop
        shop.addProduct(toaster);
        // Try to remove invalid Product from Shop
        assertFalse(shop.removeProduct(bread));
        // Try to remove valid Product from Shop
        assertTrue(shop.removeProduct(toaster));
        // Try to remove already removed Product from Shop
        assertFalse(shop.removeProduct(toaster));
        // Try to remove null Product from Shop
        assertFalse(shop.removeProduct(null));
    }

    @Test
    void addInventory() {
        // Add valid Product to Shop
        shop.addProduct(toaster);
        // Try to add quantity of invalid Product to Shop
        assertFalse(shop.addInventory(bread, 1));
        // Try to add valid quantity of valid Product to Shop
        assertTrue(shop.addInventory(toaster, 12));
        // Try to add negative quantity of valid Product to Shop
        assertFalse(shop.addInventory(toaster, -1));
        // Try to add negative quantity of null Product to Shop
        assertFalse(shop.addInventory(null, 100));
    }

    @Test
    void removeInventory() {
        // Add valid Product to Shop
        shop.addProduct(toaster);
        // Add quantity of Product to Shop
        shop.addInventory(toaster, 12);
        // Try to remove quantity of invalid Product from Shop
        assertFalse(shop.addInventory(bread, 1));
        // Try to remove valid quantity of valid Product from Shop
        assertTrue(shop.removeInventory(toaster, 2));
        // Try to remove invalid quantity of valid Product from Shop
        assertFalse(shop.removeInventory(toaster, 100));
    }

    @Test
    void getProductList() {
        // Test empty list
        assertEquals(0, shop.getProductList().size());
        // Add valid Product to Shop
        shop.addProduct(toaster);
        // Test singleton list
        assertEquals(1, shop.getProductList().size());
        assertTrue(shop.getProductList().contains(toaster));
        // Add valid Product to Shop
        shop.addProduct(bread);
        // Test multiple list
        assertEquals(2, shop.getProductList().size());
        assertTrue(shop.getProductList().contains(bread));
        // Test list equality
        List<Product> expectedList = new ArrayList<>();
        expectedList.add(toaster);
        expectedList.add(bread);
        assertEquals(expectedList, shop.getProductList());
    }

    @Test
    void getInventory() {
        // Get inventory when no items are in shop
        assertEquals(0, shop.getInventory().size());
        // Add valid Product to Shop
        shop.addProduct(toaster);
        // Get inventory when Product in shop, but no quantity
        assertEquals(1, shop.getInventory().size());
        assertTrue(shop.getInventory().contains(toaster));
        // Add quantity of Product to shop
        shop.addInventory(toaster, 12);
        // Get inventory when Product in shop and has quantity
        assertTrue(shop.getInventory().contains(toaster));
    }

    @Test
    void getName() {
        assertEquals("Arthur's Appliances", shop.getName());
    }

    @Test
    void setName() {
        assertEquals("Arthur's Appliances", shop.getName());
        shop.setName("Arthur's Avocados");
        assertEquals("Arthur's Avocados", shop.getName());
    }

    @Test
    void testToString() {
        // Empty shop
        String expected = "Shop [name=Arthur's Appliances, accountNumber=123, Merchant=(User [Name: Arthur, Type: Merchant]), productList=[], inventory=[]]";
        assertEquals(expected, shop.toString());
        // Add valid Product to Shop
        shop.addProduct(toaster);
        // Add quantity of Product to shop
        shop.addInventory(toaster, 12);
        // Shop with inventory
        System.out.println(shop.toString());
        expected = "Shop [name=Arthur's Appliances, accountNumber=123, Merchant=(User [Name: Arthur, Type: Merchant]), productList=[Product [name=Toaster, price=12.99, tags=[]]], inventory=[[product=Product [name=Toaster, price=12.99, tags=[]], quantity=12]]]";
        assertEquals(expected, shop.toString());
    }
}