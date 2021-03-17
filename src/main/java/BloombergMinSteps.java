class BloombergMinSteps {
    public int minSteps(String s, String t) {
        int[] hashA = new int[26];
        int[] hashB = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hashA[s.charAt(i) - 'a']++;
            hashB[t.charAt(i) - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (hashA[i] - hashB[i] > 0) {
                sum += Math.abs(hashA[i] - hashB[i]);
            }

        }

        return sum;
    }
}