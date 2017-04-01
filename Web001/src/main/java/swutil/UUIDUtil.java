package swutil;

import java.util.Random;
import java.util.UUID;

public  class UUIDUtil {
	public static String getRandom(){
		return  UUID.randomUUID().toString().replace("-", "");
	}
}
