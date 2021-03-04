import java.util.ArrayList;
import java.util.List;

//GS

public class MonsoonUmbrella {
    public static void main(String[] args) {
        List<Integer> sizes = new ArrayList<>();
        sizes.add(4);
        sizes.add(1);
        sizes.add(3);
        System.out.println(getUmbrellas(10, sizes));
    }

    public static int getUmbrellas(int requirement, List<Integer> sizes) {
        if (requirement < 1) return 0;

        return getUmbrellas(requirement, sizes, new int[requirement]);
    }

    private static int getUmbrellas(int requirement, List<Integer> sizes, int[] counts) {
        if (requirement < 0) return -1;
        if (requirement == 0) return 0;

        if (counts[requirement - 1] != 0) return counts[requirement - 1];

        int min = Integer.MAX_VALUE;
        for (int size : sizes) {
            int count = getUmbrellas(requirement - size, sizes, counts);
            if (count >= 0 && count < min) min = 1 + count;
        }

        counts[requirement - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return counts[requirement - 1];
    }
}
