package genericutilities;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
	
	// This method is used to capture the System Time & Date
	public String getSystemTime() {
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
		return timestamp;
	}
	
	//This method is used to generate random number according to the given bound
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}

}
