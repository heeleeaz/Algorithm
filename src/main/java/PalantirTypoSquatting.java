import java.util.*;

public class PalantirTypoSquatting {
    public static void main(String[] args) {
        testTypo1();
    }

    private static void testTypo1() {
        List<String> domains = Arrays.asList("palantir.com", "nic.ci");
        List<String> newDomains = Arrays.asList("paiantir.com", "nic.cl", "palantirtechnologies.com", "nlc.biz");
        System.out.println(getTypos1(domains, newDomains));
    }

    private static void testTypo2() {
        List<String> domains = Arrays.asList("palantir.com", "nic.ci");
        List<String> newDomains = Arrays.asList("paiantir.com", "nic.cl", "palantirtechnologies.com", "nlc.biz");
        System.out.println(getTypos(domains, newDomains));
    }

    private static void testTypo3() {
        List<String> domains = Arrays.asList("palantir.com", "apple.com");
        List<String> newDomains = Arrays.asList("palantir.com", "apalantirtechnologies.com", "paple.com", "fapples.biz");
        System.out.println(getTypos(domains, newDomains));
    }


    public static List<String> getTypos1(List<String> companyDomains, List<String> newDomains) {
        List<String> result = new ArrayList<>();

        Set<String> companyDomainSet = new HashSet<>(companyDomains);
        for (String newDomain : newDomains) {
            if (!companyDomainSet.contains(newDomain)) {
                //check newDomain it may be invalid
                //run newDomain against all company domain
                for (String companyDomain : companyDomainSet) {
                    if (isTypo(companyDomain, newDomain)) {
                        result.add(newDomain);
                        break;
                    }
                }
            }

        }
        return result;
    }

    public static List<String> getTypos2(List<String> companyDomains, List<String> newDomains) {
        List<String> result = new ArrayList<>();

        List<Set<Character>> map = new ArrayList<>();
        map.add(new HashSet<>() {{
            add('1');
            add('i');
            add('l');
            add('!');
            add('|');
        }});
        map.add(new HashSet<>() {{
            add('S');
            add('5');
            add('$');
        }});
        map.add(new HashSet<>() {{
            add('o');
            add('0');
        }});
        map.add(new HashSet<>() {{
            add('a');
            add('@');
        }});
        map.add(new HashSet<>() {{
            add('e');
            add('3');
        }});

        Set<String> companyDomainSet = new HashSet<>(companyDomains);
        for (String newDomain : newDomains) {
            boolean isTypo = false;
            if (!companyDomainSet.contains(newDomain)) {
                for (String companyDomain : companyDomainSet) {
                    if (isTypo(companyDomain, newDomain)) {
                        result.add(newDomain);
                        isTypo = true;
                        break;
                    }
                }

                if (!isTypo && isTypoWithCharacter(map, companyDomainSet, newDomain, 0)) {
                    result.add(newDomain);
                }
            }
        }
        return result;
    }

    public static List<String> getTypos3(List<String> companyDomains, List<String> newDomains) {
        List<String> result = new ArrayList<>();

        List<Set<Character>> map = new ArrayList<>();
        map.add(new HashSet<>() {{
            add('1');
            add('i');
            add('l');
            add('!');
            add('|');
        }});
        map.add(new HashSet<>() {{
            add('S');
            add('5');
            add('$');
        }});
        map.add(new HashSet<>() {{
            add('o');
            add('0');
        }});
        map.add(new HashSet<>() {{
            add('a');
            add('@');
        }});
        map.add(new HashSet<>() {{
            add('e');
            add('3');
        }});

        Set<String> companyDomainSet = new HashSet<>(companyDomains);
        for (String newDomain : newDomains) {
            boolean isTypo = false;
            if (!companyDomainSet.contains(newDomain)) {
                for (String companyDomain : companyDomainSet) {
                    if (isTypo(companyDomain, newDomain)) {
                        result.add(newDomain);
                        isTypo = true;
                        break;
                    }
                }

                if (!isTypo && isTypoWithCharacter(map, companyDomainSet, newDomain, 0)) {
                    result.add(newDomain);
                } else if (isSwapTypo(companyDomainSet, newDomain)) {
                    result.add(newDomain);
                }
            }
        }
        return result;
    }

    public static List<String> getTypos(List<String> companyDomains, List<String> newDomains) {
        List<String> result = new ArrayList<>();
        List<Set<Character>> map = new ArrayList<>();
        map.add(new HashSet<>(Arrays.asList('1', 'i', 'l', '!', '|')));
        map.add(new HashSet<>(Arrays.asList('S', '5', '$')));
        map.add(new HashSet<>(Arrays.asList('o', '0')));
        map.add(new HashSet<>(Arrays.asList('a', '@')));
        map.add(new HashSet<>(Arrays.asList('e', '3')));

        Set<String> companyDomainSet = new HashSet<>(companyDomains);
        for (String newDomain : newDomains) {
            for (String companyDomain : companyDomainSet) {
                if (isTypo(companyDomain, newDomain)) {
                    result.add(newDomain);
                    break;
                }
            }
            if (!companyDomainSet.contains(newDomain)) {
                if (isTypoWithCharacter(map, companyDomainSet, newDomain, 0)) {
                    result.add(newDomain);
                } else if (isSwapTypo(companyDomainSet, newDomain)) {
                    result.add(newDomain);
                }
            }
        }
        return result;
    }

    public static boolean isTypo(String companyDomain, String newDomain) {
        String[] companyDomainArr = companyDomain.split("\\.");
        String[] newDomainArr = newDomain.split("\\.");

        if (companyDomainArr[0].equals(newDomainArr[0])) {//domain name
            boolean isDiffHostName = !companyDomainArr[1].equals(newDomainArr[1]);
            if (isDiffHostName) {

            } else {
                return newDomain.replace(companyDomain, "").length() != 0;
            }
        }
        return false;
    }

    public static boolean isTypoWithCharacter(List<Set<Character>> map, Set<String> companyDomainSet, String newDomain, int start) {
        if (companyDomainSet.contains(newDomain)) return true;
        for (int i = start; i < newDomain.length(); i++) {
            Character c = newDomain.charAt(i);
            Set<Character> replacement = getReplacement(map, c);
            if (replacement != null) {
                for (Character character : replacement) {
                    if (character != c) {
                        String update = newDomain.substring(0, i) + character + newDomain.substring(i + 1);
                        if (isTypoWithCharacter(map, companyDomainSet, update, i + 1)) return true;
                    }

                }
            }
        }
        return false;
    }

    public static boolean isSwapTypo(Set<String> domains, String newDomain) {
        for (int i = 0; i < newDomain.length() - 1; i++) {
            String swappedDomain = swap(newDomain, i);
            if (domains.contains(swappedDomain)) return true;
        }
        return false;
    }

    public static String swap(String domain, int index) {
        if (index >= domain.length() - 1) return domain;
        char[] arr = domain.toCharArray();
        char tem = arr[index];
        arr[index] = arr[index + 1];
        arr[index + 1] = tem;
        return String.valueOf(arr);
    }

    public static Set<Character> getReplacement(List<Set<Character>> map, Character c) {
        for (Set<Character> set : map) {
            if (set.contains(c)) return set;
        }
        return null;
    }
}
