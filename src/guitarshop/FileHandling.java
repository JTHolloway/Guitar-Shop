package guitarshop;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileHandling {

    public static String folderDirectory = System.getProperty("user.dir") + "\\StockList.txt";

    public static void writeFile(ArrayList<Instruments> Stock) {
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < Stock.size(); i++) {
                printToFile.println(Stock.get(i).toStringFile());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static ArrayList<Instruments> readFile() {
        
        ArrayList<Instruments> Instruments = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] InstDetails = lineFromFile.split(", ");
                Instruments Inst = new Instruments(InstDetails[0], InstDetails[1], InstDetails[2], InstDetails[3], Integer.parseInt(InstDetails[4]), 
                        Integer.parseInt(InstDetails[5]),Integer.parseInt(InstDetails[6]), Double.parseDouble(InstDetails[7]), InstDetails[8]);
                //String Instrument, String type, String manufacturer, String colour, int numberOfStringsKeysEtc, int stock,int reserves, double cost, String code
                Instruments.add(Inst); 
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return Instruments;
    }
    
    public static void clearFile() {
        try {
            FileOutputStream writer = new FileOutputStream(System.getProperty("user.dir") + "\\StockList.txt");
            writer.write(("").getBytes());
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
