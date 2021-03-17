import java.util.*;

class BloombergWordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> characterQueue = new LinkedList<>();

        boolean[] isVisited = new boolean[s.length()];
        characterQueue.offer(0);
        while (!characterQueue.isEmpty()) {
            int start = characterQueue.poll();
            if (isVisited[start]) {
                continue;
            }

            System.out.println(start);

            for (int end = start + 1; end <= s.length(); end++) {
                System.out.println(s.substring(start, end));
                if (wordSet.contains(s.substring(start, end))) {
                    System.out.println("Q " + s.substring(start, end));
                    characterQueue.offer(end);
                    if (s.length() == end) {
                        return true;
                    }
                }
            }
            isVisited[start] = true;
        }

        return false;
    }
}