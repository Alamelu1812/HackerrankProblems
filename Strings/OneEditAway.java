/*
 * There are three type of edits that can be performed on a string - insert a character, replace a character, remove a character.
 * Write a function to check if two strings are exactly one edits away
 *
 */

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length()  == t.length())
            return oneEditReplace(s,t);
        if(s.length() + 1 == t.length())
            return oneEditInsert(s,t);
        if(s.length() == t.length() + 1)
            return oneEditInsert(t,s);
        return false;
    }
    
    public boolean oneEditReplace(String s,String t){
        boolean foundOne = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != t.charAt(i)){
                if(foundOne)
                    return false;
                foundOne = true;
            }
        }
        return foundOne;
    }
    
    public boolean oneEditInsert(String s,String t){
        int index1 = 0, index2 = 0;
        while(index1 < s.length() && index2 < t.length()){
            if(s.charAt(index1)!=t.charAt(index2)){
                if(index1!=index2)
                    return false;
                index2++;
            }
            else{
                index2++;
                index1++;
            }
        }
        return true;
    }
}
