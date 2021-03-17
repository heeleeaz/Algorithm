import java.util.HashMap;
import java.util.Map;

class BloombergUndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
    private Map<String, Pair<Integer, Integer>> journeyMap = new HashMap<>();

    public BloombergUndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInData = checkInMap.get(id);
        String startStation = checkInData.key;
        int checkInTime = checkInData.value;

        String stationKey = stationKey(startStation, stationName);
        Pair<Integer, Integer> station = journeyMap.getOrDefault(stationKey, new Pair<>(0, 0));
        int totalTime = station.key;
        int totalTrips = station.value;

        journeyMap.put(stationKey, new Pair<>(totalTime + (t - checkInTime), totalTrips + 1));

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Integer> journey = journeyMap.get(stationKey(startStation, endStation));
        int totalTime = journey.key;
        int totalTrip = journey.value;

        return totalTime / (totalTrip * 1d);
    }

    private String stationKey(String startStation, String endStation) {
        return startStation + "->" + endStation;
    }

    class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
