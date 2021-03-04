import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArraysIntersection {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int m = 0, n = 0, o = 0;

        List<Integer> intersections = new ArrayList<>();
        while (m < arr1.length && n < arr2.length && o < arr3.length) {
            if (arr1[m] == arr2[n] && arr2[n] == arr3[o]) {
                intersections.add(arr1[m]);
                m++;
                n++;
                o++;
            } else if (arr1[m] < arr2[n]) {
                m++;
            } else if (arr2[n] < arr3[o]) {
                n++;
            } else {
                o++;
            }
        }

        return intersections;


    }
}