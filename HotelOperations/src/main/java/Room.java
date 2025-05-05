public class Room {
    int numberOfBeds;
    double price;
    boolean occupied;
    boolean dirty;

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {

        return !isDirty() && !isOccupied();
    }



}
