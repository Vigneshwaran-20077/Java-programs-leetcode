import java.util.HashMap;
import java.util.Map;

Public class UndergroundSystem {

    // Helper class to track check-in data for a user
    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Helper class to accumulate total travel time and count for a route
    private static class RouteInfo {
        double totalTime;
        int tripCount;

        RouteInfo(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    // Maps id -> CheckInInfo
    private Map<Integer, CheckInInfo> checkInMap;
    
    // Maps "startStation->endStation" -> RouteInfo
    private Map<String, RouteInfo> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove check-in record for this customer
        CheckInInfo startInfo = checkInMap.remove(id);
        
        String routeKey = startInfo.stationName + "->" + stationName;
        int duration = t - startInfo.time;
        
        // Update the route total time and count
        RouteInfo route = routeMap.getOrDefault(routeKey, new RouteInfo(0, 0));
        route.totalTime += duration;
        route.tripCount += 1;
        
        routeMap.put(routeKey, route);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeMap.get(routeKey);
        return route.totalTime / route.tripCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */