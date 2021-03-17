import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class BloombergRandomizedSet {

    private final HashMap<Integer, Integer> map;
    private final List<Integer> arrayList;

    public BloombergRandomizedSet() {
        map = new HashMap<>();
        arrayList = new ArrayList<>();
    }


    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, arrayList.size());
        arrayList.add(arrayList.size(), val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int indexOfVal = map.get(val);
        int lastItem = arrayList.get(arrayList.size() - 1);
        arrayList.set(indexOfVal, lastItem);
        map.put(lastItem, indexOfVal);

        arrayList.remove(arrayList.size() - 1);
        map.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return arrayList.get(new Random().nextInt(arrayList.size()));
    }
}
