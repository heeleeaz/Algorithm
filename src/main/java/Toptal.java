import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Toptal {
    public static void main(String[] args) {
//        System.out.println(solution("00-44  48 5555 8361"));
//        System.out.println(solution("0 - 22 1985--324"));
//        System.out.println(phoneContact(new String[]{"pim", "pom"}, new String[]{"999999999", "777888999"}, "88999"));
//        System.out.println(phoneContact(new String[]{"sander", "amy", "ann", "michael"}, new String[]{"123456789", "234567890", "789123456", "123123123"}, "1"));
//        System.out.println(phoneContact(new String[]{"adam", "eva", "leo"}, new String[]{"121212121", "111111111", "444555666"}, "112"));
        System.out.println(solution(2014, "April", "May", ""));
    }

    public static String formatPhoneNumber(String S) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= '0' && c <= '9') {
                builder.append(c);
            }
        }

        int remainingLength = builder.length();
        for (int i = 3; i < builder.length() - 1; i += 4) {
            builder.insert(i, '-');
            remainingLength = builder.length() - (i + 1);
        }

        if (remainingLength == 4) {
            builder.insert(builder.length() - 2, '-');
        }

        return builder.toString();
    }

    public static String phoneContact(String[] A, String[] B, String P) {
        TreeMap<String, String> treeMap = new TreeMap<>();

        for (int i = 0; i < A.length; i++) {
            treeMap.put(A[i], B[i]);
        }

        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            String name = entry.getKey();
            String phone = entry.getValue();

            if (phone.contains(P)) {
                return name;
            }
        }

        return "NO CONTACT";
    }

    public static int solution(int Y, String A, String B, String W) {
        // write your code in Java SE 8
        var from = Calendar.getInstance();
        from.set(Calendar.YEAR, Y);
        from.set(Calendar.MONTH, getMonth(A));
        from.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        var to = Calendar.getInstance();
        to.set(Calendar.YEAR, Y);
        to.set(Calendar.MONTH, getMonth(B));

        int currentMonth = getMonth(B);
        to.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        to.set(Calendar.WEEK_OF_MONTH, 4);

        System.out.println("A" + to.get(Calendar.MONTH));


        int count = 0;
        while (from.getTimeInMillis() < to.getTimeInMillis()) {
            from.roll(Calendar.WEEK_OF_YEAR, 1);
            count += 1;
        }

        return count;
    }

    private static int getMonth(String month) {
        return new HashMap<String, Integer>() {
            {
                put("January", 0);
                put("February", 1);
                put("March", 2);
                put("April", 3);
                put("May", 4);
                put("June", 5);
                put("July", 6);
                put("August", 7);
                put("September", 8);
                put("October", 9);
                put("November", 10);
                put("December", 10);
            }
        }.get(month);
    }
}
