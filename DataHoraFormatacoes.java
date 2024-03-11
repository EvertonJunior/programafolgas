package dataEHora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataHoraFormatacoes {

	public static void main(String[] args) {
		
		LocalDate d04 = LocalDate.parse("2022-07-20");// formato ISO data local
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26"); // formato iso data e hora local
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z"); // formato iso global. 
		
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formatando
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); //formatando data e hora.
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());// para uma datahora global.
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME; // comando pronto ja, para hora local
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT; // comando pronto para hora global
		
		System.out.println("d04 = " + d04.format(fmt1));
		System.out.println("d04 = " + fmt1.format(d04));
		System.out.println("d04 = " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		System.out.println("d05 = " + d05.format(fmt1));
		System.out.println("d05 = " + d05.format(fmt2));
		System.out.println("d05 = " + d05.format(fmt4));

		System.out.println("d06 = " + fmt3.format(d06));
		System.out.println("d06 = " + fmt5.format(d06));
		System.out.println("d06 = " + d06.toString());
	}
}