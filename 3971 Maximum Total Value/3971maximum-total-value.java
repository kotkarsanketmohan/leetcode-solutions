class Solution {
    static final long MOD = 1_000_000_007L;
    public int maxTotalValue(int[] value, int[] decay, int m) {
        long low = 0, high = 0;

        for(int v: value) {
            high = Math.max(high,v);
        }
        while(low<high) {
            long mid = (low+high+1) / 2;

            if(countTerms(value, decay, mid) >= m) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        long threshold = low;
        long cnt = 0;
        long sum = 0;

        for(int i = 0; i<value.length; i++) {
            long v = value[i];
            long d = decay[i];
            long k;

            if(d==0) {
                if(v>=threshold) {
                    k=m;
                } else {
                    k=0;
                }
            } else {
                if(v<threshold) {
                    k=0;
                } else {
                    k = (v-threshold)/d+1;
                }
            }
            cnt+=k;

            if(k>0) {
                long last = v - (k-1) *d;
                sum+= k*(v+last)/2;
            }
        }
        long extra = cnt-m;
        sum -= extra*threshold;
        sum%=MOD;

        if(sum<0) sum+=MOD;

        return (int) sum;
    }
    private long countTerms(int[] value, int[] decay, long x) {
        long cnt = 0;
        for(int i=0; i<value.length; i++) {
            long v = value[i];
            long d = decay[i];

            if(d==0) {
                if(v>=x) {
                    cnt+=(long) 1e18;
                } 
            } else if(v>=x) {
                    cnt+= (v-x)/d+1;
            }
        }
        return cnt;
    }
}