import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read {

    public static void main(String args[]) {
        String pathJuan = "";
        String pathFran = "";
        String line = "";

        try {
            BufferedReader br = new BufferedReader( new FileReader(pathFran));
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
