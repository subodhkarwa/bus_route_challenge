import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        BusServer server = new BusServer();
        server.start();
    }
}
