public class DroneFlightPlanner {

    static int calcDroneMinEnergy(int[][] route) {
        int currGas = 0;
        int neededGas = 0;
        for (int i = 1; i < route.length; i++) {
            int dist = route[i - 1][2] - route[i][2];
            currGas += dist;
            if (currGas < 0 && currGas < neededGas) {
                neededGas = currGas;
                currGas = 0;
            }
        }
        return -neededGas;
    }

    public static void main(String[] args) {
        int[][] route = { {0,   2, 10},
                {3,   5,  0},
                {9,  20,  6},
                {10, 12, 15},
                {10, 10,  8} };
        // Expected output: 5 #
        /* less than 5 kWh and the drone would crash before the finish line.
        More than `5` kWh and it’d end up with excess energy. */
        System.out.println(calcDroneMinEnergy(route));
    }
}
