import java.io.*;
import static spark.Spark.*;
import routes.BusServer;
import routes.BusRouter;

public class Main {
    public static void main(String[] args) {
        BusRouter br = parseInputFile(args[0]);
        //        BusServer server = new BusServer(br);
        //        server.start();
    }

    public static BusRouter parseInputFile(String filename) {
        String current;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BusRouter();
    }
}
