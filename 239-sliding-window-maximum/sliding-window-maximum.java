class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int z = 0;

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        st.push(n-1);
        nge[n-1] = -1;

        for(int i=n-2;i>=0;i--) {
            while(!st.isEmpty() && nums[i] > nums[st.peek()])
                st.pop();

            if(st.isEmpty())
                nge[i] = -1;
            else
                nge[i] = st.peek();

            st.push(i);
        }

        int log = 1;
        while((1 << log) <= n)
            log++;

        int[][] jump = new int[log][n];

        for(int i=0;i<n;i++)
            jump[0][i] = nge[i];

        for(int p=1;p<log;p++) {
            for(int i=0;i<n;i++) {
                int next = jump[p-1][i];

                if(next == -1)
                    jump[p][i] = -1;
                else
                    jump[p][i] = jump[p-1][next];
            }
        }

        for(int i=0;i<n-k+1;i++) {
            int end = i+k;
            int j = i;

            for(int p=log-1;p>=0;p--) {
                int next = jump[p][j];

                if(next != -1 && next < end)
                    j = next;
            }

            ans[z] = nums[j];
            z++;
        }
        return ans;
    }
}