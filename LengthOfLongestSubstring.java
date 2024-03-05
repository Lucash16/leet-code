public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] charIndex = new int[128]; // Assuming ASCII characters

        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(charIndex[s.charAt(j)], i);
            maxLength = Math.max(maxLength, j - i + 1);
            charIndex[s.charAt(j)] = j + 1;
        }

        return maxLength;
    }
}

