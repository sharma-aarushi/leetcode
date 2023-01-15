class Solution853 {
    // time complexity: O(nlgn)
    // Space complexity (extra space):O(n)
    public int carFleet(int target, int[] positions, int[] speeds) {
        if (positions.length == 0) {
            return 0;
        }
        Car[] cars = new Car[positions.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(positions[i], speeds[i]);
        }
        Arrays.sort(cars);// sorting cars by position (ascending order)
        Car fleetHead = cars[cars.length - 1];
        int numFleets = 1;
        for (int i = cars.length - 2; i >= 0; i--) {// n-2 since fleethead is already considered at pos[n-1]
            double currFleetTime = fleetHead.destinationTime(target);
            double currTime = cars[i].destinationTime(target);
            if (currTime > currFleetTime) {// if currTime<currFleetTime it becomes part of fleet
                numFleets++; // if currTime=currFleetTime it becomes part of the fleet at the target
                fleetHead = cars[i]; // current car becomes new fleethead
            }
        }
        return numFleets;
    }

    static class Car implements Comparable<Car> {
        int pos;
        int speed;

        Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public int compareTo(Car car2) {
            return this.pos - car2.pos;
        }

        public double destinationTime(int target) {
            double time = ((double) (target - this.pos)) / this.speed;
            return time;
        }
    }
}