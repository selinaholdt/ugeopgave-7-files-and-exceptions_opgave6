public class Drink {
    private String name;
    private int price;
    private int soldNumber;

    public Drink(String name, int price, int soldNumber) {
        this.name = name;
        this.price = price;
        this.soldNumber = soldNumber;
    }

    public String getName() {
        return name;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber){
        this.soldNumber = soldNumber;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {// — returnerer data i CSV-format: "Espresso, 25, 42"
        return name + ", " + price + ", " + soldNumber;
    }
}
