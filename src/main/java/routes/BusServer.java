package routes;

import static spark.Spark.*;
import spark.*;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Set;
import java.util.HashMap;

public class BusServer {
    private BusRouter busRouter;

    public BusServer(BusRouter busRouter) {
        this.busRouter = busRouter;
    }

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
        HashMap <String, Object> resp = new HashMap();
        Gson gson = new Gson();

        boolean result = busRouter.findDirectRoute(dep_sid, arr_sid);

        resp.put("dep_sid", dep_sid);
        resp.put("arr_sid", arr_sid);
        resp.put("direct_bus_route", result);

        return gson.toJson(resp);
    }

    public boolean hasValidParameters(Request request) {
        Set params = request.queryParams();

        return params.contains("dep_sid") && params.contains("arr_sid");
    }
}
