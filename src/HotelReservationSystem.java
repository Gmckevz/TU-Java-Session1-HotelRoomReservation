import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] roomNumbers = new int[10];
        for (int i = 0; i < roomNumbers.length; i++) {
            roomNumbers[i] = 101 + i;
        }

        boolean[] isBooked = new boolean[10];

        int choice;

        System.out.println("Welcome to the Hotel Reservation System");
        System.out.println("1. View Available Rooms");
        System.out.println("2. Book a Room");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. Exit");

        do {
            System.out.print("Enter choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    viewAvailableRooms(roomNumbers, isBooked);
                    break;
                case 2:
                    bookARoom(scan, roomNumbers, isBooked);
                    break;
                case 3:
                    cancelReservation(scan, roomNumbers, isBooked);
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }

public static void viewAvailableRooms (int[] roomNumbers, boolean[] isBooked){
            System.out.println("Available rooms:");
            boolean isAvailable = false;
            for (int i = 0; i < roomNumbers.length; i++){
                if (!isBooked[i]){
                    System.out.print(roomNumbers[i] + " ");
                    isAvailable = true;
                }
            }
            if (!isAvailable) {
                System.out.println("No room available.");
            }
            System.out.println(" ");
    }
public static void bookARoom (Scanner scan, int[] roomNumbers, boolean[] isBooked){
            System.out.print("Enter room number to book: ");
            int bookedRoom = scan.nextInt();
            int roomIndex = bookedRoom - 101;

            if (roomIndex < 0 || roomIndex >= roomNumbers.length){
                System.out.println("Invalid room");
            } else if (isBooked[roomIndex]) {
                System.out.println("Room " + bookedRoom + " is already booked.");
            } else {
                isBooked[roomIndex] = true;
                System.out.println("Room " + bookedRoom + " booked successfully.");
            }
    }
public static void cancelReservation (Scanner scan, int[] roomNumbers, boolean[] isBooked){
            System.out.print("Enter room number to cancel: ");
            int roomToCancel = scan.nextInt();
            int roomIndex = roomToCancel - 101;
            if (roomIndex < 0 || roomIndex >= roomNumbers.length){
                System.out.println("Invalid room");
            } else if (!isBooked[roomIndex]) {
                System.out.println("Room " + roomToCancel + " not currently booked.");
            } else {
                isBooked[roomIndex] = false;
                System.out.println("Room " + roomToCancel + " reservation canceled.");
            }
            }

}