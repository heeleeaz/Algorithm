class ReverseVowels {
    public String reverseVowels(String s) {
        int l = 0, h = s.length() -1;
        
        char[] characters = s.toCharArray();
        while(l<h){
            System.out.println(l + " -- "+ h);

            if(isVowel(characters[l]) && isVowel(characters[h])){
                char lChar = characters[l];
                char hChar = characters[h];

                characters[l] = hChar;
                characters[h] = lChar;
                
                l++;
                h--;
            }else if(isVowel(characters[l])){
                h--;
            }else{
                l++;
            }
        }
        return String.valueOf(characters);
    }
    
    public boolean isVowel(char c){
        return "aeiouAEIOU".contains(String.valueOf(c));
    }
}