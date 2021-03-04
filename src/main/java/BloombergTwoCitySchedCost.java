import java.util.Arrays;
import java.util.Comparator;

class BloombergTwoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {

        //sort from the highest to the lowest.
        //input: [[10,20],[30,200],[400,50],[30,20]]
        //sorted: [30, 200][10, 20][30, 20][400, 50]
        //as in, -170, -10, 10, 350
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });


        int sum = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            sum += costs[i][0] + costs[i + n][1];
        }


        return sum;
    }
}