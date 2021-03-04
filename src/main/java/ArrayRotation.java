import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayRotation {
    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>(5);
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(5);
        System.out.println(rotateLeft(4, v));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < arr.size(); i++) {
            int index = (i + d) % arr.size();
            list.add(i, arr.get(index));
        }

        return list;

    }
}
