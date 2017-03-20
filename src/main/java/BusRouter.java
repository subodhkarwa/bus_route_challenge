import java.util.*;

class BusRoute {
    private ArrayList<Integer> stations;
    private Integer id;

    BusRoute(Integer id) {
        this.id = id;
        this.stations = new ArrayList();
    }

    public void addStation(Integer id) {
        stations.add(id);
    }

    public boolean hasStations(Integer dep, Integer arr) {
        Integer di = stations.indexOf(dep);
        Integer ai = stations.indexOf(arr);

        if (di == -1 || ai == -1) {
            return false;
        } else {
            return di < ai;
        }
    }
}

public class BusRouter {
    private HashSet<BusRoute> routes;

    public static void main(String args[]) {
        BusRouter br = new BusRouter();

        BusRoute a = new BusRoute(0);
        a.addStation(0);
        a.addStation(1);
        a.addStation(2);
        a.addStation(3);
        a.addStation(4);
        br.addRoute(a);

        a = new BusRoute(1);
        a.addStation(3);
        a.addStation(1);
        a.addStation(6);
        a.addStation(5);
        br.addRoute(a);

        a = new BusRoute(2);
        a.addStation(2);
        a.addStation(0);
        a.addStation(6);
        a.addStation(4);
        br.addRoute(a);

        System.out.println(br.findDirectRoute(4, 6));
    }

    public BusRouter() {
        this.routes = new HashSet();
    }

    public void addRoute(BusRoute route) {
        routes.add(route);
    }

    public boolean findDirectRoute(Integer dep, Integer arr) {
        for (BusRoute route : routes) {
            if (route.hasStations(dep, arr)) {
                return true;
            }
        }
        return false;
    }
}
