package udemy.excecao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import udemy.excecao.model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out Date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			Date checkin2 = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			Date checkout2 = sdf.parse(sc.next());

			String error = reservation.updateDate(checkin2, checkout2);

			if (error != null) {
				System.out.println("Error Reservatin: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}

		}

		sc.close();
	}
}
