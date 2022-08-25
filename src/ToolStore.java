public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Magazaya hosgeldiniz ! \n**********");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar \n2 - Zirhlar \n3 - Cikis yap \n**");
            System.out.print("Seciniz : ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("\nGecersiz bir deger girdiniz, lutfen tekrar deneyiniz !");
                System.out.print(" * \nSeciniz : ");
                selectCase = Location.input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("\nTekrar bekleriz :)");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("\t\t\t\t\tSilahlar");
        System.out.println("\t\t\t>>>>>>>>>>>><<<<<<<<<<<<");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID " + w.getId() + " ----> " + "Silah: " + w.getName() + " ----> " + "Fiyat: " + w.getPrice() + " || Hasar: " + w.getDamage());
        }
        System.out.println("\t\t\t>>>>>>>>>>>><<<<<<<<<<<<");
        System.out.println("0 - Cikis yap");
    }

    public void buyWeapon() {
        System.out.print("Bir silah seciniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Gecersiz bir deger girdiniz, lutfen tekrar deneyiniz ! ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yetersiz bakiye !");
                } else {
                    // satın almanın gerçekleştiği yer
                    System.out.println(selectedWeapon.getName() + " silahini basariyla satin aldiniz ! ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiye : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmor() {
        System.out.println("\t\t\t\t\tZirhlar");
        System.out.println("\t\t\t>>>>>>>>>>>><<<<<<<<<<<<");
        for (Armor a : Armor.armors()) {
            System.out.println("ID " + a.getId() + " ----> " + "Zirh: " + a.getName() + " ----> " + "Fiyat: " + a.getPrice() + " || Bloklama: " + a.getBlock());
        }
        System.out.println("0 - Cikis yap");
    }

    public void buyArmor() {
        System.out.println("Bir sirh seciniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Gecersiz bir deger girdiniz, lutfen tekrar deneyiniz ! ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yetersiz bakiye !");
                } else {
                    // satın almanın gerçekleştiği yer
                    System.out.println(selectedArmor.getName() + " zirhini basariyla satin aldiniz ! ");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiye : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }


    }
}
