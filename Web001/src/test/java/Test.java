import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test{
	public static void main(String[] args) throws Exception {
		Set set=new HashSet<>();
		int a[]={1,2,2,3,4,45,45};
		for (int i=0;i<a.length;i++){
			if(set.contains(a[i])){
				System.out.println();
			}
		}
	} 
}