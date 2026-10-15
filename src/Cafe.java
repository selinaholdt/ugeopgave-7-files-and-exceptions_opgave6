import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {
    private ArrayList<Drink> coffeeMenu = new ArrayList<>();

    public Cafe() {
        loadData("data/menu.csv");
    }

    public ArrayList<Drink> getCoffeeMenu() {
        return coffeeMenu;
    }

    public void loadData(String path) { //— læser data/menu.csv og opretter Drink-objekter
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()){
                String s = scan.nextLine();
                String[] values = s.split(",");

                coffeeMenu.add(new Drink(values[0].trim(),
                        Integer.parseInt(values[1].trim()),
                        Integer.parseInt(values[2].trim())));
            }
        } catch (FileNotFoundException e){
            System.out.println("Fejl. Kan ikke finde filen.");
        }
    }

    public void saveData() { //— gemmer den opdaterede menu tilbage til filen
        try {
            FileWriter writer = new FileWriter("data/menu.csv");
            writer.write("Name, Price, SoldNumber \n");
            for (Drink drink : coffeeMenu) {
                writer.write(drink.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File unavailable");;
        }
    }

    public void showMenu() { //— viser menuen og lader brugeren vælge
        int menuCount = 1;
        System.out.println("Afslut bestilling ved at taste 0.");
        for (Drink coffee : coffeeMenu){
            System.out.println(menuCount + ") " + coffee.getName() + ", " + coffee.getPrice() + " kr.");
            menuCount++;
        }
    }
}
