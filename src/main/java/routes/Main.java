package routes;
import java.io.*;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        BusRouter br = parseInputFile(args[0]);
        BusServer server = new BusServer(br);
        server.start();
    }

    public static BusRouter parseInputFile(String filename) {
        BusRouter busRouter = new BusRouter();
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            Integer numRoutes = Integer.parseInt(br.readLine());
            for (int i = 0; i < numRoutes; i++) {
                String[] currentRoute = br.readLine().split(" ");
                Route r = new Route(Integer.parseInt(currentRoute[0]));
                for (int j = 1; j < currentRoute.length; j++) {
                    r.addStation(Integer.parseInt(currentRoute[j]));
                }
                busRouter.addRoute(r);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return busRouter;
    }
}
