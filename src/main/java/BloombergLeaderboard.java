import java.util.*;

//https://leetcode.com/problems/design-a-leaderboard/
public class BloombergLeaderboard {
    TreeMap<Integer, Integer> sortedScores;
    HashMap<Integer, Integer> scores;

    public BloombergLeaderboard() {
        sortedScores = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, score);
            sortedScores.put(score, sortedScores.getOrDefault(score, 0) + 1);
        } else {
            int preScore = scores.get(playerId);
            int playerCount = sortedScores.get(preScore);

            //reduce the score count by -1 and remove if after reduction, the value is now 0
            if (playerCount == 1) {
                sortedScores.remove(preScore);
            } else {
                sortedScores.put(preScore, playerCount - 1);
            }

            //update score count new scores map
            //update the newScore by 1; create and init as 1, if it does not already exists
            int newScore = preScore + score;
            scores.put(playerId, newScore);
            sortedScores.put(newScore, sortedScores.getOrDefault(newScore, 0) + 1);
        }
    }

    public int top(int K) {
        int sum = 0;
        int count = 0;
        Iterator<Map.Entry<Integer, Integer>> entryIterator = sortedScores.entrySet().iterator();
        for (Map.Entry<Integer, Integer> entry : sortedScores.entrySet()) {
            int key = entry.getKey();
            int times = entry.getValue();

            for (int i = 0; i < times; i++) {
                sum += key;
                count++;

                // Found top-K scores, break.
                if (count == K) break;
            }

            // Found top-K scores, break.
            if (count == K) break;
        }

        return sum;
    }

    public void reset(int playerId) {
        int score = scores.get(playerId);
        sortedScores.put(score, sortedScores.get(score) - 1);
        if (sortedScores.get(score) == 0) {
            sortedScores.remove(score);
        }
        scores.remove(playerId);
    }
}

class BloombergLeaderboard2 {
    HashMap<Integer, Integer> scores;

    public BloombergLeaderboard2() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            heap.offer(entry.getValue());
            if (heap.size() > K) {
                heap.poll(); // remove element at the head
            }
        }

        int total = 0;
        for (Integer integer : heap) {
            total += integer;
        }

        return total;
    }

    public void reset(int playerId) {
        scores.put(playerId, 0);
    }
}