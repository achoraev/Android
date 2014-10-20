public class RandomGift {	
	
	public static void main(String[] args) {		
		System.out.println("Enter name of your friend...");
		String nameOfFriendString = System.console().readLine();
		System.out.println(nameOfFriendString);
		System.out.println("Choose of follow: ");
		System.out.println("1. Xmas");
		System.out.println("2. Birthday");
		System.out.println("3. Anniversary");
		int holiday = Integer.parseInt(System.console().readLine());
		switch (holiday) {
		case 1:
			System.out.println(1);
			break;

		case 2:
			System.out.println(2);		
			break;
					
		case 3:
			System.out.println(3);
			break;
	
		default:
			break;
		}
	}

}