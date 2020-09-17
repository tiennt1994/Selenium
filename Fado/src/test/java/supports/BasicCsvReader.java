package supports;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class BasicCsvReader {
    public static void main(String [] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("Login Data Test.csv"));
        reader.readLine(); //skip the first line
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("username", "password").withIgnoreHeaderCase().withTrim());

        String username = null;
        for (CSVRecord csvRecord: csvParser) {
            // Accessing Values by Column Index
            username = csvRecord.get(0);
            //Printing the record
            //System.out.println("Record Number - " + csvRecord.getRecordNumber());
            System.out.println("Username : " + username);
            //System.out.println("Password : " + password);
            System.out.println("\n");
        }
    }

    public static String read() throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get("Login Data Test.csv"));
        reader.readLine(); //skip the first line
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("username", "password").withIgnoreHeaderCase().withTrim());

        String username = null;
        for (CSVRecord csvRecord: csvParser) {
            // Accessing Values by Column Index
            username = csvRecord.get(0);
            //String password = csvRecord.get(1);

            //Accessing the values by column header name
            //String column = csvRecord.get("username");

            //Printing the record
            //System.out.println("Record Number - " + csvRecord.getRecordNumber());
            //System.out.println("Username : " + username);
            //System.out.println("Password : " + password);
            //System.out.println("\n");
        }
        return username;
    }
    public static String read1() throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get("Login Data Test.csv"));
        reader.readLine(); //skip the first line
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("username", "password").withIgnoreHeaderCase().withTrim());

        String password = null;
        for (CSVRecord csvRecord : csvParser) {
            // Accessing Values by Column Index
            password = csvRecord.get(1);
        }
        return password;
    }
}