package org.opennaas.extensions.vrf.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Josep Batallé (josep.batalle@i2cat.net)
 */
public class RoutingTable {

    private static final long serialVersionUID = -4002472167559948067L;
    Log log = LogFactory.getLog(RoutingTable.class);
    private List<VRFRoute> routeTable = new ArrayList<VRFRoute>();
    private int version;

    public RoutingTable(int version) {
        this.version = version;
        routeTable = new ArrayList<VRFRoute>();
    }

    public List<VRFRoute> getRouteTable() {
        return routeTable;
    }

    public void setRouteTable(List<VRFRoute> routeTable) {
        this.routeTable = routeTable;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public VRFRoute getRouteId(int id) {
        for (VRFRoute r : this.routeTable) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public String addRoute(VRFRoute route) {
        if (RouteExists(route) == 0) {
            if (this.routeTable.isEmpty()) {
                route.setId(1);
            } else {
                route.setId(routeTable.get(routeTable.size() - 1).getId() + 1);
            }
            routeTable.add(route);
            return "Added";
        }
        return "Already exist";
    }

    public Boolean removeRoute(int id) {
        for (VRFRoute r : this.routeTable) {
            if (r.getId() == id) {
                this.routeTable.remove(r);
                return true;
            }
        }
        log.info("This route no exists.");
        return false;
    }

    public void removeRoute(VRFRoute route) {
        routeTable.remove(route);
    }

    public void removeRoutes() {
        routeTable.clear();
    }

    public int RouteExists(VRFRoute route) {
        for (VRFRoute r : this.routeTable) {
            if (r.equals(route)) {
                log.error("The route "+r.getSourceAddress()+" "+r.getDestinationAddress()+" "+r.getSwitchInfo().getDPID()+" exist!");
                return r.getId();
            }
        }
        log.error("This route no exists.");
        return 0;
    }

    public int getOutputPort(int id) {
        for (VRFRoute r : this.routeTable) {
            if (r.getId() == id) {
                log.info("OutputPort = " + r.getSwitchInfo().getOutputPort());
                return r.getSwitchInfo().getOutputPort();
            }
        }
        return 0;
    }

    public int getOutputPort(VRFRoute route) {
        for (VRFRoute r : this.routeTable) {
            if (r.equals(route)) {
                log.info("OutputPort = " + r.getSwitchInfo().getOutputPort());
                return r.getSwitchInfo().getOutputPort();
            }
        }
        return 0;
    }

    public List<VRFRoute> getListRoutes(VRFRoute route, L2Forward srcSwInfo, L2Forward destSwInfo) {
        List<VRFRoute> subnetList = new ArrayList<VRFRoute>();
        VRFRoute route2 = new VRFRoute();
        route2.setSourceAddress(route.getDestinationAddress());
        route2.setDestinationAddress(route.getSourceAddress());
        for (VRFRoute r : this.getRouteTable()) {
            if (!r.getSwitchInfo().getDPID().equals(srcSwInfo.getDPID())) {
                if (r.equalsOtherRoutes(route)) {
                    subnetList.add(r);
                } else if (r.equalsOtherRoutes(route2)) {
                    subnetList.add(r);
                }
            }
        }
        log.info("Returning all Routes.");
        return subnetList;
    }
    
    public List<VRFRoute> getListRoutes(VRFRoute route) {
        List<VRFRoute> subnetList = new ArrayList<VRFRoute>();
        VRFRoute route2 = new VRFRoute();
        route2.setSourceAddress(route.getDestinationAddress());
        route2.setDestinationAddress(route.getSourceAddress());
        for (VRFRoute r : this.getRouteTable()) {
                if (r.equalsOtherRoutes(route)) {
                    subnetList.add(r);
                } else if (r.equalsOtherRoutes(route2)) {
                    subnetList.add(r);
                }
        }
        log.info("Returning all Routes.");
        return subnetList;
    }
}
