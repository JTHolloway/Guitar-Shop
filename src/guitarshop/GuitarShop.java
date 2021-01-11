package guitarshop;

import java.util.ArrayList;
import java.util.Scanner;

public class GuitarShop {

    static ArrayList<Instruments> AllStock = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        boolean staff = false;
        String input = "";

        Instruments guitar = new Instruments("Guitar", "Electric", "Fender", "Brown", 6, 14, 149.99, "1",0);
        System.out.println(guitar.toString());
        Instruments hello = new Instruments("Flute", "Acoustic", "Flutey", "Sliver", 0, 7, 50.00, "5",2);
        System.out.println(hello.toString());
        AllStock.add(guitar);
        AllStock.add(hello);

        do {
            System.out.println("->Are you; \n1 - staff or \n2 - customer?");
            input = s.next();
            switch (input) {
                case "1":
                    if(password()){
                       staff = true; 
                    }else{
                       staff = false;
                       input = "0";
                    }
                    break;
                case "2":
                    staff = false;
                    break;
                default:
                    System.out.println("Invalid\n");
            }
        } while (!(input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2")));

        if (staff) {
            String Search = "search";
            do {
                System.out.println("\n-->Do you want to add/remove/edit/search for Instruments");
                Search = s.next();

                if (Search.equalsIgnoreCase("add")) {
                    add();
                } else if (Search.equalsIgnoreCase("remove")) {
                    remove();
                } else if (Search.equalsIgnoreCase("edit")) {
                    edit();
                } else if (Search.equalsIgnoreCase("search")) {
                    search();
                } else {
                    System.out.println("->Invalid Input");
                }

            } while (true);

        } else {
            String Search = "search";
            do {
                System.out.println("\n-->Would you like to search/reserve");
                Search = s.next();

                if (Search.equalsIgnoreCase("reserve")) {
                    reserve();
                } else if (Search.equalsIgnoreCase("search")) {
                    search();
                } else {
                    System.out.println("->Invalid Input");
                }

            } while (true);
        }
    }

    public static void remove() {
        System.out.println("->Type Product Code");
        String ProductCode = s.next();

        int index = -1;
        for (int i = 0; i < AllStock.size(); i++) {
            if (ProductCode.equalsIgnoreCase(AllStock.get(i).getProductCode())) {
                index = i;
                break;
            } else if (i == AllStock.size() - 1) {
                System.out.println("->Product Code Not Found");
            }
        }

        if (index != -1) {
            System.out.println("-->Are you sure you would like to remove this " + AllStock.get(index).getManufacturer() + " " + AllStock.get(index).getInstrument() + "? yes or no");
            do {
                String choice = s.next();
                if (!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no"))) {
                    System.out.println("->Invaild Input, try again");
                } else if (choice.equalsIgnoreCase("yes")) {
                    AllStock.remove(index);
                    System.out.println("->Item with Product Code " + ProductCode + " has been removed.");
                    break;
                } else {
                    System.out.println("->Item has not been removed.");
                    break;
                }
            } while (true);
        }
    }

    public static void edit() {
        System.out.println("->Please type the product code");
        String ProductCode = s.next();

        int index = -1;
        if (!AllStock.isEmpty()) {
            for (int i = 0; i < AllStock.size(); i++) {
                if (ProductCode.equalsIgnoreCase(AllStock.get(i).getProductCode())) {
                    index = i;
                    break;
                } else if (i == AllStock.size() - 1) {
                    System.out.println("->Product code does not exist");
                }
            }
        } else {
            System.out.println("->Product not in stock");
        }

        int edit = 0;
        boolean loop = false;
        if (index != -1) {
            System.out.println("\n----" + AllStock.get(index).toString() + "----");
        }

        do {
            loop = false;
            if (index != -1) {
                System.out.println("->What would you like to edit?");
                System.out.println("1 - Instrument");
                System.out.println("2 - type");
                System.out.println("3 - manufacturer");
                System.out.println("4 - colour");
                System.out.println("5 - Number of keys/Strings");
                System.out.println("6 - stock");
                System.out.println("7 - cost");
                System.out.println("8 - Product Code");
                System.out.println("9 - Reservations");
                edit = s.nextInt();

                switch (edit) {
                    case 1:
                        System.out.println("Enter a new Instrument Name");
                        AllStock.get(index).setInstrument(s.next());
                        break;
                    case 2:
                        System.out.println("Enter a new Instrument Type");
                        AllStock.get(index).setType(s.next());
                        break;
                    case 3:
                        System.out.println("Enter a new Manufacturer");
                        AllStock.get(index).setManufacturer(s.next());
                        break;
                    case 4:
                        System.out.println("Enter a new Colour");
                        AllStock.get(index).setColour(s.next());
                        break;
                    case 5:
                        System.out.println("Enter Number of strings / keys");
                        AllStock.get(index).setNumberOfStringsKeysEtc(s.nextInt());
                        break;
                    case 6:
                        System.out.println("Enter Stock");
                        AllStock.get(index).setStock(s.nextInt());
                        break;
                    case 7:
                        System.out.println("Enter Cost");
                        AllStock.get(index).setCost(s.nextInt());
                        break;
                    case 8:
                        System.out.println("Enter new Product Code");
                        String NewProductCode;
                        int check = -1;
                        do {
                            NewProductCode = s.next();
                            for (int i = 0; i < AllStock.size(); i++) {
                                if (NewProductCode.equalsIgnoreCase(AllStock.get(i).getProductCode())) {
                                    System.out.println("\n->Product code already exists, choose another code: ");
                                    check = -1;
                                    break;
                                } else if (i == AllStock.size() - 1) {
                                    check = 1;
                                }
                            }
                        } while (check == -1);
                        AllStock.get(index).setProductCode(NewProductCode);
                        break;
                    case 9:
                        System.out.println("Enter Reservations");
                        AllStock.get(index).setReserves(s.nextInt());
                        break;
                    default:
                        if (edit < 1 || edit > 8) {
                            System.out.println("Invalid choice, choose again");
                            loop = true;
                        }
                        break;
                }
            }
        } while (loop);
    }

    public static void search() {
        System.out.println("->Type Product Code");
        String ProductCode = s.next();

        int index = -1;
        for (int i = 0; i < AllStock.size(); i++) {
            if (ProductCode.equalsIgnoreCase(AllStock.get(i).getProductCode())) {
                index = i;
                break;
            } else if (i == AllStock.size() - 1) {
                System.out.println("->Product Code Not Found");
            }
        }

        if (index != -1) {
            System.out.println(AllStock.get(index).toString());
        }
    }

    public static void add() {
        System.out.print("\nEnter Instrument: ");
        String Instrument = s.next();
        System.out.print("Enter Instrument type: ");
        String type = s.next();
        System.out.print("Enter Manufacturer: ");
        String manufacturer = s.next();
        System.out.print("Enter colour: ");
        String colour = s.next();
        System.out.print("Enter Number Of Keys/Strings: ");
        int notes = s.nextInt();
        System.out.print("Enter Stock: ");
        int Stock = s.nextInt();
        System.out.print("Enter Number of Reservations: ");
        int reserves = s.nextInt();
        System.out.print("Enter Cost: ");
        int Cost = s.nextInt();

        int index = -1;
        String ProductCode = "-1";
        do {
            System.out.print("\nEnter ProductCode: ");
            ProductCode = s.next();
            for (int i = 0; i < AllStock.size(); i++) {
                if (ProductCode.equalsIgnoreCase(AllStock.get(i).getProductCode())) {
                    System.out.println("\n->Product code already exists, choose another code: ");
                    index = -1;
                    break;
                } else if (i == AllStock.size() - 1) {
                    index = 1;
                }
            }
        } while (index == -1);

        AllStock.add(new Instruments(Instrument, type, manufacturer, colour, notes, Stock, Cost, ProductCode,reserves));
    }

    public static void reserve() {
        System.out.println("Type in Product Code");
        String ProductCode = s.next();

        int index = -1;
        for (int i = 0; i < AllStock.size(); i++) {
            if (ProductCode.equalsIgnoreCase(AllStock.get(i).getProductCode())) {
                index = i;
                break;
            } else if (i == AllStock.size() - 1) {
                System.out.println("->Product Code Not Found");
            }
        }

        if (index != -1) {
            System.out.println("-->Were you looking for: " + AllStock.get(index).getManufacturer() + " " + AllStock.get(index).getColour() + " " + AllStock.get(index).getType() + " " + AllStock.get(index).getInstrument() + "?");
            do {
                String choice = s.next();
                if (!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no"))) {
                    System.out.println("->Invaild Input, try again");
                } else if (choice.equalsIgnoreCase("yes")) {

                    if (AllStock.get(index).getStock() > 0) {
                        System.out.println("-->Would you like to reserve item?");

                        do {
                            String Reserve = s.next();
                            if (!(Reserve.equalsIgnoreCase("yes") || Reserve.equalsIgnoreCase("no"))) {
                                System.out.println("->Invaild Input, try again");
                            } else if (Reserve.equalsIgnoreCase("yes")) {
                                AllStock.get(index).setStock(AllStock.get(index).getStock()-1);
                                AllStock.get(index).setReserves(AllStock.get(index).getReserves()+1);
                                
                                System.out.println("->Item Reserved");
                                break;
                                
                            } else {
                                System.out.println("->Returning to main menu");
                                break;
                            }
                        } while (true);

                    } else {
                        System.out.println("->Sorry, Item is out of stock at the moment, try again later!");
                    }

                    break;
                } else {
                    System.out.println("->Would you like to search for a new Item?");
                    do {
                        String choice2 = s.next();
                        if (!(choice2.equalsIgnoreCase("yes") || choice2.equalsIgnoreCase("no"))) {
                            System.out.println("->Invaild Input, try again");
                        } else if (choice2.equalsIgnoreCase("yes")) {
                            reserve();
                            break;
                        } else {
                            System.out.println("->Returning to main menu");
                            break;
                        }
                    } while (true);

                    break;
                }
            } while (true);
        }
    }
    
    public static boolean password(){
        System.out.print("Enter Password:");
        String Password = s.next();
        
        if (Password.equals("Guitar123")){
            System.out.println("Correct Password");
            return true;
        }else{
            System.out.println("Password Incorrect");
            return false;
        }
    }
}
