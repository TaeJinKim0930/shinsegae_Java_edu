package telbook;

import java.io.IOException;
import java.util.Scanner;

public class AddressExample {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		Menue m = new Menue();
		
		while (true) {
			m.showMenue();
			String a = sc.next();
			m.choiceMenue(a);
			
			System.out.println("-------------------");
			}
		

	}

}
