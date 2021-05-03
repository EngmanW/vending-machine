package logging;

import java.io.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Logger implements Closeable {


        private File logFile;
        private PrintWriter writer;

        private LocalDateTime localDateTime = LocalDateTime.now();
        private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a");
        private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        public Logger(String logFile) {
            this.logFile = new File(logFile);

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

        public void loggingAction(double startingBalance, double endingBalance) {

            this.write(">" + dtf.format(localDateTime) + " FEED MONEY: " + nf.format(startingBalance) + " " + nf.format(endingBalance) );
        }

    public void loggingActionProduct(double startingBalance, double endingBalance, String name, String code) {

        this.write(">" + dtf.format(localDateTime) + " " + name + " "
                + code + " " + nf.format(startingBalance) + " " + nf.format(endingBalance) );
    }

    public void loggingCashOut(double startingBalance) {

        this.write(">" + dtf.format(localDateTime) + " GIVE CHANGE: " + nf.format(startingBalance) + " " + nf.format(0) );
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
