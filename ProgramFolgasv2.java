package dataEHora;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class ProgramFolgasv2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a data que deseja saber se estará de folga: EX 11/03/2024");
		String nextFolga = sc.next();
		
		System.out.println("Digite sua escala: ");
		System.out.println("1 - 4x2");
		System.out.println("2 - 6x1 alternando sab/dom");
		int perg = sc.nextInt();
		
		if (perg == 1) {
			System.out.println("Digite a data do seu ultimo segundo dia de folga: EX 05/03/2024");
			String lastFolga = sc.next();
			if ((diferencaDias(lastFolga,nextFolga)+1) % 6 == 0) {
				System.out.printf("No dia %s %s será seu primeiro dia de folga.%n",nextFolga,diaDaSemana(nextFolga));
			}
			else if (diferencaDias(lastFolga,nextFolga) % 6 == 0){
				System.out.printf("No dia %s %s será seu segundo dia de folga.%n",nextFolga,diaDaSemana(nextFolga));
			}
			else {
				System.out.printf("No dia %s %s você não estará de folga.%n",nextFolga,diaDaSemana(nextFolga));
			}
		}
		
		else if (perg == 2) {
			System.out.println("Digite a data da sua ultima folga (SAB/DOM): EX 03/03/2024");
			String lastFolga = sc.next();
			if (diaDaSemana(lastFolga).equals("sábado")) {
				if(diferencaDias(lastFolga,nextFolga)==8 || diferencaDias(lastFolga,nextFolga) %14 == 0 || (diferencaDias(lastFolga,nextFolga) -8) % 14==0) {
					System.out.printf("No dia %s %s você estará de folga.%n",nextFolga,diaDaSemana(nextFolga));
				}
				else {
					System.out.printf("No dia %s %s você não estará de folga.%n",nextFolga,diaDaSemana(nextFolga));
				}
			}
			
			if (diaDaSemana(lastFolga).equals("domingo")) {
				if(diferencaDias(lastFolga,nextFolga)==6 || diferencaDias(lastFolga,nextFolga) %14 == 0 || (diferencaDias(lastFolga,nextFolga) -6) % 14==0) {
					System.out.printf("No dia %s %s você estará de folga.%n",nextFolga,diaDaSemana(nextFolga));
				}
				else {
					System.out.printf("No dia %s %s você não estará de folga.%n",nextFolga,diaDaSemana(nextFolga));
				}
			}
		}
		
		
		
		
		sc.close();
	}
	public static long diferencaDias(String data1, String data2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate lastFolga = LocalDate.parse(data1, formatter);
		LocalDate nextFolga = LocalDate.parse(data2, formatter);
		long diferencaDias = lastFolga.until(nextFolga,ChronoUnit.DAYS);
		return diferencaDias;
	}
	
	public static String diaDaSemana(String data2) {
		Locale localeBR = new Locale("pt", "BR");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nextFolga = LocalDate.parse(data2, formatter);
		DayOfWeek diaDaSemana = nextFolga.getDayOfWeek();
		String txtDiaDaSemana = diaDaSemana.getDisplayName(TextStyle.FULL, localeBR);
		return txtDiaDaSemana;
	}
	
}
