package dataEHora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataHora {

	public static void main(String[] args) {
		// data-hora local = quando nao interessar o fuso horario, EX: data-hora da venda 15:34
		// data hora global= quando o fuso horario ser importante EX: quando sera o sorteio? 21/08/2022 as 20hrs, quando foi realizada a venda 15:34 horario de sao paulo,
		// GMT= horario de londres! os outros horarios são gmt pra mais ou pra menos.
		//EX: SÃO PAULO = GMT-3 = SAO PAULO TEM 3 HORAS A MENOS QUE LONDRES, PORTUGAL = GMT+1  portugual tem 1 hora a mais que londres.
		
		// PADRAO ISO 8601
		
		
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formatando para //
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); //formatando para //
		LocalDate d01 = LocalDate.now(); // DATA LOCAL ATUAL
		LocalDateTime d02 = LocalDateTime.now(); //DATA E HORA ATUAL
		Instant d03 = Instant.now(); // DATA E HORA GLOBAL (LONDRES)
		LocalDate d04 = LocalDate.parse("2024-03-05");// DATA LOCAL FORMATO ISO
		LocalDateTime d05 = LocalDateTime.parse("2024-03-05T01:30:26"); // DATA E HORA LOCAL FORMATO ISO
		Instant d06 = Instant.parse("2024-03-05T01:30:26Z"); //DATA GLOBAL FORMATO ISO
		Instant d07 = Instant.parse("2024-03-05T01:30:26-03:00"); //GLOBAL DATA E HORA FORMATO ISO
		
		LocalDate d08 = LocalDate.parse("05/03/2024", fmt1); //EXEMPLO FORMATADO
		LocalDateTime d09 = LocalDateTime.parse("05/03/2024 01:30", fmt2); //EXEMPLO FORMATADO
		
		LocalDate d10 = LocalDate.of(2022,7,20);// OUTRA FORMA DE COLOCAR HORA E DATA
		LocalDateTime d11 = LocalDateTime.of(2022,7,20,1,30); 
		LocalTime d12 = LocalTime.of(1,30); // APENAS HORA
		
		System.out.println("d02 = " + d02);
		System.out.println("d01 = " + d01);
		System.out.println("d03 = " + d03);
		System.out.println("d04 = " + d04);
		System.out.println("d05 = " + d05);
		System.out.println("d06 = " + d06);
		System.out.println("d07 = " + d07);
		System.out.println("d08 = " + d08);
		System.out.println("d09 = " + d09);
		System.out.println("d10 = " + d10);
		System.out.println("d11 = " + d11);
		System.out.println("d12 = " + d12);
	}

}