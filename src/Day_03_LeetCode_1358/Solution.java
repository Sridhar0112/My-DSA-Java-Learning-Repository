package Day_03_LeetCode_1358;
/*
1358. Number of Substrings Containing All Three Characters
Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b and c.
Example 1:
Input:
s = "abcabc"
Output:
10

Example 2:
Input:
s = "aaacb"
Output:
3

Example 3:
Input:
s = "abc"
Output:
1

Constraints:
3 <= s.length <= 5 * 10^4

s only consists of a, b or c characters.
*/

class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += s.length() - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }
}
