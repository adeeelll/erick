
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author arslan
 */
public class Main {

    public static void readFile(String str) throws IOException {
        String subLine = "";
        int totalCount = 0;
        BufferedReader br = new BufferedReader(new FileReader("Server.log"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                if (line.equals(str)) {
                    System.out.println(line);
                    totalCount += 1;
                    for (int count = 0; count < 5; count++) {
                        subLine = br.readLine();
                        if (subLine != null && !subLine.isEmpty()) {
                            System.out.println(subLine);
                        }
                    }

                }
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();

            System.out.println("Total Occurences of given String = " + totalCount);

        } finally {
            br.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        readFile("500 Server Error");
        // TODO code application logic here
    }

}
