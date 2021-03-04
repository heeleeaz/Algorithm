import org.junit.Assert;

class CompressStringCount {
    public static void main(String[] args) {
        Assert.assertEquals(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}), "a2b2c3");
        Assert.assertEquals(compress(new char[]{'a', 'a', 'b', 'b', 'c'}), "a2b2c1");
    }

    public static String compress(char[] chars) {
        int counter = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                counter += 1;
            } else {
                builder.append(chars[i]);
                builder.append(counter + 1);
                counter = 0;
            }
        }
        return builder.toString();
    }
}