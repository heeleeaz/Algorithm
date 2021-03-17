import java.util.*;

class BloombergTopKFrequentSolution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((a, b) ->
                map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b));

        for (String word : map.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }

        return ans;
    }
}