package udemy.excecao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import udemy.excecao.model.entities.Reservation;
import udemy.excecao.model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) throws ParseException {

		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			Date checkin2 = sdf.parse(sc.next());
			System.out.print("Check-out Date (dd/MM/yyyy): ");
			Date checkout2 = sdf.parse(sc.next());
			reservation.updateDate(checkin2, checkout2);
			System.out.println("Reservation: " + reservation);

			sc.close();
		} catch (ParseException e) {
			System.out.println("invalid format date.");
		} catch (DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
	}
}
