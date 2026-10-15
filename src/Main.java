import java.util.ArrayList;

public class Main {

    void main(){
        TextUI ui = new TextUI();
        Cafe cafe = new Cafe();

        int choice = 1;
        ArrayList<Drink> menu = cafe.getCoffeeMenu();
        int total = 0;

        cafe.showMenu();
        while ((choice > 0) && (choice <= menu.size())) {
            choice = ui.promptNumeric("Vælg en kaffe fra menuen, ved brug af et tal:");
            if (choice == 0 || choice > menu.size()) {break;}

            Drink drink = menu.get(choice-1);

            total += drink.getPrice();
            drink.setSoldNumber(drink.getSoldNumber()+1);
            System.out.println(drink);

            cafe.saveData();
        }
        System.out.println("At betale: " + total + " kr.");
    }
}
