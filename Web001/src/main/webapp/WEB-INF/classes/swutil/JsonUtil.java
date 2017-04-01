package swutil;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

public class JsonUtil {
	private static Gson gson=new Gson();
	public static String toJson(Object str){
		if (str == null) {  
            return gson.toJson(JsonNull.INSTANCE);  
        }  
        return gson.toJson(str);  
	} 
	
}
