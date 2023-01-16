package Api;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	
	

	public static void main(String[] args) throws IOException, InterruptedException{
		
		Scanner sa = new Scanner(System.in);
		ReadingApi api=new ReadingApi();

		do {
			
			
			System.out.println("..........................");

		System.out.println("////////////////////////////////////");
		System.out.println("////////////Main Menue//////////////");
		System.out.println("///     1.Read From Api          ///");
		System.out.println("///     2.Create Table           ///");
		System.out.println("///     3.Inset Value Into Table ///");
		System.out.println("////////////////////////////////////");
		
		System.out.println("plz select option...");
		int list = sa.nextInt();
		System.out.println("..........................");

		
		switch(list){
		
		case 1:
			
			api.ReadFromApi();
			
			break;
			
		case 2:
			
			api.CreateApiTable();
			
			break;
			
		case 3:
			
			api.InsertValue();
			
			break;
		
		}
		}while(true);
		
	}

}
