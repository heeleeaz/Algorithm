class ValidateIP {

    //192.168.0.1
    static boolean validateIP(String ip) {
        // your code goes here
        String[] components = ip.split("\\.");
      System.out.println(components.length);

      if (components.length != 4) {
            return false;
        }



        //00
        for (String c : components) {
            if (isValidMask(c)) {
                int cInt = Integer.parseInt(c);
                if (cInt > 255 || (cInt == 0 && c.length() > 1)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }


    //255
    //022
    //00
    private static boolean isValidMask(String component) {
        char[] componentChar = component.toCharArray();

        for (char c : componentChar) {
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
      System.out.println(validateIP("192.168.0.1"));
      System.out.println(validateIP("0.0.0.0"));
      System.out.println(validateIP("123.24.59.99"));
      System.out.println(validateIP("192.168.123.456"));
    }
}
