class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int x = 0, y = 0;
        
        int count = 0;
        while(x < s.length() && y < t.length()){
            if(s.charAt(x) == t.charAt(y)){
                count+=1;
                
                x++;
                y++;
            }else{
                y++;
            }
        }
        
        return count == s.length();
    }
}