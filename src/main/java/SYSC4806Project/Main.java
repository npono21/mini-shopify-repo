package SYSC4806Project;

import java.util.ArrayList;
import java.util.List;

// TODO: enforce shop name uniqueness

/**
 * Initializes system and holds entities.
 */
public class Main {
    private final List<Shop> shops = new ArrayList<>();
    private final List<Merchant> merchants = new ArrayList<>();
    private final List<Buyer> buyers = new ArrayList<>();

    public boolean addShop(Shop shop) {
        return shops.add(shop);
    }

    private boolean addMerchant(Merchant merchant) {
        return merchants.add(merchant);
    }

    private boolean addBuyer(Buyer buyer) {
        return buyers.add(buyer);
    }

    private boolean removeShop(Shop shop) {
        return shops.remove(shop);
    }

    private boolean removeMerchant(Merchant merchant) {
        return merchants.remove(merchant);
    }

    private boolean removeBuyer(Buyer buyer) {
        return buyers.remove(buyer);
    }

    public Merchant loginMerchant(String username, String password) {
        for (Merchant merchant : merchants) {
            if (merchant.login(username, password)) {return merchant;}
        }
        return null;
    }

    public Buyer loginBuyer(String username, String password) {
        for (Buyer buyer : buyers) {
            if (buyer.login(username, password)) {return buyer;}
        }
        return null;
    }

    public Shop getShopByName(String shopName) {
        for (Shop shop : shops) {
            if (shop.getName().equals(shopName)) {return shop;}
        }
        return null;
    }

    // simple manual test at the moment
    public static void main(String[] args) {
        Main main = new Main();
        Merchant merchant = new Merchant("iSell", "makeDaMoneys", main);
        Buyer buyer = new Buyer("iBuy", "spendDaMoneys", main);
        main.addMerchant(merchant);
        main.addBuyer(buyer);

        Shop shop1 = merchant.createShop("shop1", 1111);
        Shop shop2 = merchant.createShop("shop2", 2222);

        Product apple =  new Product("apple", 1.50);

        merchant.addProductToShop(shop1,apple);
        merchant.setProductQuantity(shop1, apple, 100);

        System.out.println(shop1);
    }
}
