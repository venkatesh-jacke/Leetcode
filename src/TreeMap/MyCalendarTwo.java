package TreeMap;

import java.util.Map;
import java.util.TreeMap;

class MyCalendarTwo {

    TreeMap<Integer, Integer> stops;


    public MyCalendarTwo() {
        stops = new TreeMap<>();

    }


    public boolean book(int start, int end) {
        stops.put(start, stops.getOrDefault(start, 0) + 1);
        stops.put(end, stops.getOrDefault(end, 0) - 1);
        int booked = 0;
        for (Map.Entry<Integer, Integer> stop : stops.entrySet()) {
            booked += stop.getKey();
            if (booked > 2) {
                stops.put(start, stops.getOrDefault(start, 0) - 1);
                stops.put(end, stops.getOrDefault(end, 0) + 1);
                if (stops.get(start) == 0) stops.remove(start);
                if (stops.get(stop) == 0) stops.remove(stop);
                return false;
            }
        }
        return true;
    }
}
