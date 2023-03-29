public class RootOfNumber {

    static double root(double x, int n) {
        double l = 0.0, r = x;
        double mid = 0.0;
        while (l < r) {
            mid = (l + r) / 2;
            if (Math.pow(mid, n) > x && Math.pow(mid, n) > 0.001) {
                r = mid;
            } else if (Math.pow(mid, n) < x && x - Math.pow(mid, n) > 0.001) {
                l = mid;
            } else {
                break;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        double x = 7;
        int n = 3;
        // Expected output: 1.913
        System.out.println(root(x, n));

        x = 9;
        n = 2;
        // Expected output: 3
        System.out.println(root(x, n));
    }
}
