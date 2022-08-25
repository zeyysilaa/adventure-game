public class Armor {
    private int id, block, price;
    private String name;

    public Armor(String name, int id, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }
    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Hafif" ,1, 1,15);
        armorList[1] = new Armor("Orta" , 2 , 3,25);
        armorList[2] = new Armor("Agir",3 , 5,40);
        return armorList;
    }
    public static Armor getArmorObjByID(int id){
        for (Armor a: Armor.armors()) {
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
