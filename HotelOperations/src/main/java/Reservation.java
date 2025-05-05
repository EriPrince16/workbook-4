public class Reservation {
    String roomType;
    int numberOfNights;
    boolean isWeekend;

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        if (roomType.equals("king")) {
            return 139.00;
        } else if (roomType.equals("double")) {
            return 124.00;
        } else {
            throw new RuntimeException("Invalid room type!");
        }
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setRoomType(String roomType) {
        if (!roomType.equals("king") && !roomType.equals("double")) {
            throw new RuntimeException("Invalid room type");
        }
        this.roomType = roomType;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

}
