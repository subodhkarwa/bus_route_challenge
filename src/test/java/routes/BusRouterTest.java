package routes;

import junit.framework.Assert;
import org.junit.Test;

public class BusRouterTest {
    @Test
    public void testFindDirectRoute() {
        BusRouter br = new BusRouter();

        Route r = new Route(0);
        r.addStation(0);
        r.addStation(1);
        r.addStation(2);
        r.addStation(3);
        r.addStation(4);
        br.addRoute(r);

        r = new Route(1);
        r.addStation(3);
        r.addStation(1);
        r.addStation(6);
        r.addStation(5);
        br.addRoute(r);

        r = new Route(2);
        r.addStation(2);
        r.addStation(0);
        r.addStation(6);
        r.addStation(4);
        br.addRoute(r);

        Assert.assertEquals(br.findDirectRoute(3, 6), true);
        Assert.assertEquals(br.findDirectRoute(0, 0), true);
        Assert.assertEquals(br.findDirectRoute(4, 6), false);
    }
}
