import java.util.Random;

public class RandomGifts {
	public static void main(String[] args) {			
		Gift[] gifts = {new Gift("Parfume","Mall Sofia"),
						new Gift("Shoes","Galeria Mall"),
						new Gift("Hat","Center"),
						new Gift("Hand Bag","Open Market")};
		int giftNumber = randomNumber(0,3);
		String giftName = gifts[giftNumber].getName();
		String giftPlace = gifts[giftNumber].getPlace();
		System.out.println("Buy " + giftName + " from " + giftPlace);
	}

	public static int randomNumber(int min, int max) {
		Random rand = new Random();
		int nextIntRandom = rand.nextInt((max-min) + 1) + min;
		return nextIntRandom;
	}
}
