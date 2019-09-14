package udemy.excecao.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import udemy.excecao.model.exceptions.DomainExceptions;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExceptions {

		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions("Check-out date must be after check-in date.");
		}

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diferencaMilisegundos = this.getCheckOut().getTime() - this.getCheckIn().getTime();
		return TimeUnit.DAYS.convert(diferencaMilisegundos, TimeUnit.MILLISECONDS);
	}

	public void updateDate(Date checkin, Date checkout) throws DomainExceptions {
		Date now = new Date();

		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainExceptions("Reservation dates for update must be future dates.");
		}

		if (!checkout.after(checkin)) {
			throw new DomainExceptions("Check-out date must be after check-in date");
		}

		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";

	}

}
