import static spark.Spark.*;
import spark.*;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Set;
import java.util.HashMap;

public class BusServer {
    public void start() {
        port(8088);
        get("/api/direct", (request, response) -> {
                response.type("application/json");

                if (hasValidParameters(request)) {
                    return findRoute(request);
                } else {
                    response.status(400);
                    return "Invalid parameters";
                }

            });
    }

    public String findRoute(Request request) {
        Integer dep_sid = Integer.parseInt(request.queryParams("dep_sid"));
        Integer arr_sid = Integer.parseInt(request.queryParams("arr_sid"));
        HashMap <String, Object> result = new HashMap();
        Gson gson = new Gson();

        result.put("dep_sid", dep_sid);
        result.put("arr_sid", arr_sid);
        result.put("direct_bus_route", false);

        return gson.toJson(result);

    }

    public boolean hasValidParameters(Request request) {
        Set params = request.queryParams();

        return params.contains("dep_sid") && params.contains("arr_sid");
    }
}
