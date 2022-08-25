import java.net.SocketAddress;
import java.util.Scanner;

public class Player {
    private int damage, health, originalHealth;
    private int money;
    private String name, charName, award = "";

    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Samuray samuray = new Samuray();
        Knight knight = new Knight();
        Archer archer = new Archer();
        System.out.println("\t\t\t\t\t\t\tKarakterler \n\t\t\t\t\t>>>>>>>>>>>>><<<<<<<<<<<<<");
        System.out.println("ID: " + samuray.getId() + " ----> " + "Karakter: " + samuray.getName() + " ----> " + "Hasar: " + samuray.getDamage() + " || Saglik: " + samuray.getHealth() + " || Para: " + samuray.getMoney());
        System.out.println("ID: " + archer.getId() + " ----> " + "Karakter: " + archer.getName() + " ----> " + "Hasar: " + archer.getDamage() + " || Saglik: " + archer.getHealth() + " || Para: " + archer.getMoney());
        System.out.println("ID: " + knight.getId() + " ----> " + "Karakter: " + knight.getName() + " ----> " + "Hasar: " + knight.getDamage() + " || Saglik: " + knight.getHealth() + " || Para: " + knight.getMoney());

        System.out.print("\t\t\t\t\t>>>>>>>>>>>>><<<<<<<<<<<<< \nKarakter ID'niz: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samuray());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samuray());
        }
        System.out.println("Sectiginiz karakter --> " + this.getCharName());
    }

    public void selectLoc() {

    }

    public void initPlayer(GameChar gameChar) {
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setOriginalHealth(gameChar.getHealth());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }

    public void printInfo() {
        System.out.println("Silahiniz : " + this.getInventory().getWeapon().getName() +
                " || Zirhiniz : " + this.getInventory().getArmor().getName() +
                " || Bloklama: " + this.getInventory().getArmor().getBlock() +
                " || Hasar : " + this.getTotalDamage() +
                " || Saglik : " + this.getHealth() +
                " || Para : " + this.getMoney() +
                "|| Odul :" + this.getAward());


    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        if (health < 0) {
            return 0;
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
