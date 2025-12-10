import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int rows = 0;
		
		while(true) {
			System.out.println("Please enter an odd number between 1 to 19");
			try {
				rows = keyboard.nextInt();
			}
			
			catch(Exception e){
				System.out.println("Invalid Input! Please enter a odd number between 1 to 19");
				keyboard.next();
				continue;
			}
			
			if(rows > 1 && rows < 19 && rows % 2 != 0) {
				break;
				
			}else {
				System.out.println("Invalid Input!");
				
			}
		}
		
		keyboard.close();
		int mid = rows / 2;
		
		for(int i = 0; i <= mid; i++ ) {
			for(int j = 0; j < mid - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = mid - 1; i >= 0; i-- ) {
			for(int j = 0; j < mid - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
