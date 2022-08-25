import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    private Player player;


    public void start() {
        System.out.println("Macera oyununa hosgeldiniz !");
        System.out.print("Lutfen bir isim giriniz : ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        System.out.println("Karanlik adaya hosgeldin " + player.getName() + " ;)");
        System.out.println("Lutfen bir karakter sec ! ");
        player.selectChar();

        Location location = null;

        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("\t\t\t\t\tBolgeler");
            System.out.println("\t\t\t>>>>>>>>>>>><<<<<<<<<<<<");
            System.out.println("0 - Oyunu sonlandir !");
            System.out.println("1 - Guvenli Ev --> Can doldurma veya dusmanlardan korunma");
            System.out.println("2 - Market --> Silah veya zirh satin alma");
            System.out.println("3 - Magara --> Savas alani / Odul : yemek");
            System.out.println("4 - Orman --> Savas alani / Odul : odun");
            System.out.println("5 - Nehir --> Savas alani / Odul : su");
            System.out.println("6 - Maden --> Savas alani / Odul : silah,para veya zirh");
            System.out.println("\t\t\t>>>>>>>>>>>><<<<<<<<<<<<");
            System.out.print("Lutfen girmek istediginiz bolgeyi seciniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (!isAward("Food")) {
                        location = new Cave(player);
                        break;
                    } else {
                        System.out.println("Temiz bolge!");
                        location = new SafeHouse(player);
                        break;
                    }
                case 4:
                    if (!isAward("Firewood")) {
                        location = new Forest(player);
                        break;
                    } else {
                        System.out.println("Temiz bolge!");
                        location = new SafeHouse(player);
                        break;
                    }
                case 5:
                    if (!isAward("Water")) {
                        location = new River(player);
                        break;
                    } else {
                        System.out.println("Temiz bolge!");
                        break;
                    }
                case 6:
                    if (!isAward("*")){
                        location = new Mine(player);
                        break;
                    }else {
                        System.out.println("Temiz bolge!");
                        break;
                    }
                default:
                    System.out.println("\nLutfen gecerli bir yer seciniz !");
                    location = new SafeHouse(player);
            }

            if (location == null) {
                System.out.println("Bu karanlik adadan cabuk vazgectin :( ");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("* \nOyun bitti !");
                break;
            }
            if (isWin("Food", "Firewood", "Water", "*")) {
                System.out.println("Bu karanlik adayi basariyla tamamladin , tebriklerr :)");
                break;
            }
        }
    }

    public boolean isAward(String award) {
        return this.player.getAward().contains(award);
    }

    public boolean isWin(String award1, String award2, String award3, String award4) {
        if (isAward(award1) && isAward(award2) && isAward(award3) && isAward(award4)) {
        return true;
        }else {
            return false;
        }
    }
}
