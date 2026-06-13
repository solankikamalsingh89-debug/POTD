package Leetcode_POTD.June_2026;

/*
Simply done as stated in question with same steps:
Only optimization is:
    i) ans+=('z' - (sum % 26)) ->Better going with StringBuilder because string ans need to completely first copy each char of previous ans and then add to assign new string(Immutable)
    ii)In the starting itself defining ans length

TC - O(Total chaacter), SC - O(1) {as output space is excluded}
*/

public class June_13 {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder(words.length);
        for (String word : words) {
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                sum += weights[word.charAt(i) - 'a'];
            }
            ans.append((char)('z' - (sum % 26)));
        }
        return ans.toString();
    }
}
