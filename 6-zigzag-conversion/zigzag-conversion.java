class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuffer[] res = new StringBuffer[numRows];

        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuffer();
        }

        boolean down = true;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            res[j].append(s.charAt(i));
            if (down) {
                if (j == numRows - 1) {
                    j--;
                    down = false;
                } else {
                    j++;
                }
            } else {
                if (j == 0) {
                    down = true;
                    j++;
                } else {
                    j--;
                }
            }
        }

        StringBuffer ans = new StringBuffer();
        for (StringBuffer el : res) {
            ans.append(el);
        }
        return ans.toString();
    }
}
