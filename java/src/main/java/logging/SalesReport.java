package logging;

import com.techelevator.items.VendingProduct;

import java.io.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SalesReport implements Closeable {

    private File logFile;
    private PrintWriter writer;

    private LocalDateTime localDateTime = LocalDateTime.now();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yyyy");
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

    public SalesReport() {
        this.logFile = new File("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-green-t4\\java\\src\\main\\resources\\" + dtf.format(localDateTime) + ".txt");

        if (this.logFile.exists()) {  // don't want to overwrite, want to append
            try {
                writer = new PrintWriter(new FileWriter(this.logFile, true)); // this will append
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {  // file doesn't exit, create new and start at beginning to write
            try {
                writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //Plan
    //Create load method

    public void loadProductsSalesReport(List<VendingProduct> vendingProductList) {
        if (this.logFile.length() == 0) {
            for (VendingProduct product : vendingProductList) {
                this.write(product.getName() + "|" + "0");
            }
        }
    }

    public void addNewSale(String name) {

        try (Scanner inputScanner = new Scanner(logFile)){
            StringBuffer buffer = new StringBuffer();
            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();
                if (line.contains(name)) {
                    String[] lineArray = line.split("\\|");
                    //Parse to int
                    int totalSale = Integer.parseInt(lineArray[1]);
                    //Add one
                    totalSale++;
                    //Make to a string and Reassign to lineArray[1]
                    lineArray[1] = Integer.toString(totalSale);
                    buffer.append(lineArray[0] + "|" + lineArray[1] + "\n");
                } else{
                    buffer.append(line + "\n");

                }
            }
            String fileContents = buffer.toString();
            FileWriter writerUpdate = new FileWriter(this.logFile.getAbsolutePath(), false);
            writerUpdate.append(fileContents);
            writerUpdate.flush();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Read the file
    //Find the line with the product's name and the number of total sales for that product MINUS one
    //Replace that line with the total sales updated by one by replacing with a string with the totat sales increased by one


    public String printOut(){
        int totalSales = 0;
        StringBuffer buffer = new StringBuffer();
        try (Scanner inputScanner = new Scanner(logFile)){
            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();
                buffer.append(line + "\n");
                String[] lineArray = line.split("\\|");
                totalSales += Integer.parseInt(lineArray[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return (buffer.toString() + "\n Total Sales: " + totalSales);
    }

    public void write (String logMessage){
        writer.println(logMessage);
        writer.flush();
    }

    //Addressing the close() method in Closeable Abstract Class
    @Override
    public void close() throws IOException {
        writer.close();
    }
}

