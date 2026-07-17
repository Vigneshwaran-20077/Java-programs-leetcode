public class ParkingSystem {
    // Array to store the available slots for big (index 1), medium (index 2), and small (index 3)
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        // Size 4 array to allow 1-based indexing for easy mapping
        this.slots = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // Check if there is an available slot for the given carType
        if (this.slots[carType] > 0) {
            this.slots[carType]--; // Park the car by decrementing the slot count
            return true;
        }
        return false; // No slots left for this carType
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */