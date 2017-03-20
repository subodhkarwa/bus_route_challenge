package routes;

import java.util.ArrayList;

public class Route {
    private ArrayList<Integer> stations;
    private Integer id;

    public Route(Integer id) {
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
