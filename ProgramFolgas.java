package dataEHora;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class ProgramFolgas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale localeBR = new Locale("pt", "BR");

		System.out.println("Qual sua escala? ");
		System.out.println("1 - 4x2 ");
		System.out.println("2 - 6x1 ");

		int esc = sc.nextInt();

		if (esc == 1) {
			System.out.println("Digite a data do seu ultimo segundo dia de folga: Ex 05/03/2024 ");
			String data = sc.next();
			LocalDate ultimaFolga = LocalDate.parse(data, formatter);
			System.out.println("Sua ultima folga foi: " + data);

			System.out.println("");

			System.out.println("Digite a data que deseja saber se estará de folga: EX 11/03/2024");

			String folga = sc.next();
			LocalDate duvFolga = LocalDate.parse(folga, formatter);
			DayOfWeek diaDaSemana = duvFolga.getDayOfWeek();
			String txtDiaDaSemana = diaDaSemana.getDisplayName(TextStyle.FULL, localeBR);

			long diferencaDias = ultimaFolga.until(duvFolga, ChronoUnit.DAYS);

			if ((diferencaDias + 1) % 6 == 0) {
				System.out.printf("No dia %s %s será seu primeiro dia de folga.\n", folga, txtDiaDaSemana);
			}
			else if(diferencaDias % 6 == 0) {
				System.out.printf("No dia %s %s será seu segundo dia de folga.\n", folga, txtDiaDaSemana);
			}
			else {
				System.out.printf("No dia %s não estará de folga! ", folga);
			}
		}
		
		else if(esc == 2) {
			System.out.println("Digite a data da sua última folga fixa(Sábado/domingo):   Ex 04/03/2024 ");
			String data1 = sc.next();
			LocalDate ultimaFolga = LocalDate.parse(data1, formatter);
			DayOfWeek sabDoming = ultimaFolga.getDayOfWeek();
			String txtSabDoming = sabDoming.getDisplayName(TextStyle.FULL, localeBR);
			
			System.out.println("Digite a data que deseja saber se estará de folga: EX 11/03/2024");
			String data2 = sc.next();
			LocalDate proximaFolga = LocalDate.parse(data2, formatter);
			DayOfWeek sabDoming1 = proximaFolga.getDayOfWeek();
			String txtSabDoming1 = sabDoming1.getDisplayName(TextStyle.FULL, localeBR);
			
			
			System.out.println("sua ultima folga foi: " + data1 + " " + txtSabDoming);
			
			long diferencaDias1 = ultimaFolga.until(proximaFolga, ChronoUnit.DAYS);
			
			if (txtSabDoming.equals("sábado")){
			    if (diferencaDias1 == 8 || diferencaDias1 % 14 == 0 || (diferencaDias1 - 8) % 14 == 0){
			        System.out.printf("No dia %s é um %s e você estará de folga!%n",data2, txtSabDoming1);
			    }
			    else{
			        System.out.printf("No dia %s é um %s e você não estará de folga! %n", data2, txtSabDoming1);
			    }
			}
			else if(txtSabDoming.equals("domingo")){
			    if (diferencaDias1 == 6 || diferencaDias1 % 14 == 0 || (diferencaDias1 - 6) % 14 == 0){
			        System.out.printf("No dia %s é um %s e você estará de folga!%n",data2, txtSabDoming1);
			    }
			    else{
			        System.out.printf("No dia %s é um %s e você não estará de folga! %n", data2, txtSabDoming1);
			    }
			}
			
			else{
			    System.out.printf("Dia %s é uma %s! Digite uma data válida: sab/dom: ", data1, txtSabDoming);
			}
		}
		sc.close();
	}

		
}
