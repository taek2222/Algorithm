class Solution {
    public long solution(int w, int h) {
        long W = w;
        long H = h;
        long gcd = gcd(W, H);
        return W * H - (W + H - gcd);
    }
    
    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}