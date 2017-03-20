package routes;

import java.util.HashSet;

public class BusRouter {
    private HashSet<Route> routes;

    public BusRouter() {
        this.routes = new HashSet();
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public boolean findDirectRoute(Integer dep, Integer arr) {
        if (dep == arr) {
            return true;
        }

        for (Route route : routes) {
            if (route.hasStations(dep, arr)) {
                return true;
            }
        }
        return false;
    }
}
