package bit.berik29;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DBManager dbManager = new DBManager();
        dbManager.connect();

        while (true){
            System.out.println("PRESS [1] TO ADD ITEMS");
            System.out.println("PRESS [2] TO LIST ITEMS");
            System.out.println("PRESS [3] TO DELETE ITEMS ");
            System.out.println("PRESS [0] TO EXIT");

            int choice = in.nextInt();
            if (choice==1){
                System.out.println("Insert name:");
                String name = in.next();

                System.out.println("Insert price:");
                double price = in.nextDouble();
                Item item = new Item(null, name, price);
                dbManager.addItem(item);

            } else if (choice==2){
                ArrayList<Item> items = dbManager.getAllItems();//массив называется Items видимо из-зи название Таблицы в БД
                for (Item it: items){
                    System.out.print(it.toString() + "\n");
                }

            } else if (choice==3){
                System.out.println("Insert ID:");
                Long id = in.nextLong();
                dbManager.deleteItem(id);

            } else if (choice==0){
                break;
            }


        }
    }
}
