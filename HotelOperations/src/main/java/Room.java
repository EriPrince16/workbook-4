public class Room {
    int numberOfBeds;
    double price;
    boolean occupied;
    boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

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

    public boolean checkIn() {
        if (isAvailable()) {
            occupied = true;
            dirty = true;
            return true;
        } else {
            System.out.println("Room is not available for check in.");
            return false;
        }
    }

    public boolean checkOut() {
        if (occupied) {
            occupied = false;
            return true;
        } else {
            System.out.println("Cannot check out. Room is currently not occupied.");
            return false;
        }
    }

    public void cleanRoom() {
        if (!occupied && dirty) {
            dirty = false;
            System.out.println("Room has been cleaned.");
        } else if (occupied) {
            System.out.println("Cannot clean room while occupied.");
        } else {
            System.out.println("Room is already clean.");
        }
    }

    public boolean canClean() {
        if (isDirty() && !isOccupied()) {
            return true;
        } else {
            return false;
        }
    }
}