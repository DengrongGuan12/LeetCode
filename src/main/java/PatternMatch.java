public class PatternMatch {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0){
            return true;
        }
        if (p.length() >0){
            if (p.length() > 1 && p.charAt(1) == '*'){
                return isMatch(s, p.substring(2)) || (s.length() > 0 && (s.charAt(0) == p.charAt(0)||p.charAt(0) == '.') && isMatch(s.substring(1),p));
            }else if (p.charAt(0) == '.' && s.length() > 0){
                return isMatch(s.substring(1), p.substring(1));
            }else if(s.length() > 0){
                return s.charAt(0) == p.charAt(0) && isMatch(s.substring(1), p.substring(1));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PatternMatch patternMatch = new PatternMatch();
        System.out.println(patternMatch.isMatch("ab",".*c"));
    }
}
