//import java.util.*;
//
//public class BloombergReorderArrayBasedDictionary {
//    public static void main(String[] args) {
//        Map<String, String> pairList = new HashMap<>() {{
//            put("CTO", "CEO");
//            put("Manager", "CTO");
//            put("Engineer", "Manager");
//            put("CFO", "CEO");
//        }};
//
//        List<Pair<String, String>> position = new ArrayList<>() {{
//            add(new Pair<>("John", "Manager"));
//            add(new Pair<>("Sally", "CTO"));
//            add(new Pair<>("Drax", "Engineer"));
//            add(new Pair<>("Bob", "CFO"));
//            add(new Pair<>("Sam", "CEO"));
//            add(new Pair<>("Daniel", "Engineer"));
//        }};
//
//        BloombergReorderArrayBasedDictionary a = new BloombergReorderArrayBasedDictionary();
//        System.out.println(a.flattenReportMap(pairList));
//    }
//
//    private LinkedList<String> flattenReportMap(Map<String, String> reports) {
//        LinkedList<
//                > linkedList = new LinkedList<>();
//
//
//        return linkedList;
//    }
//
//    static class Pair<F, S> {
//        F first;
//        S second;
//
//        Pair(F first, S second) {
//            this.first = first;
//            this.second = second;
//        }
//
//        @Override
//        public String toString() {
//            return "Pair{" + "first=" + first + ", second=" + second + '}';
//        }
//    }
//
//}
//
////flatten the person position dictionary
////create a new map to store result
////add key value based on order of flatten dictionary