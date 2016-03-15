import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class countcha {
	
	public static void main(String[] args)
	{
		Map<String,Integer> numcount=new HashMap<String,Integer>();	
		//regex
		Pattern pat=Pattern.compile("\\b[A-Za-z][A-Za-z0-9]{3,}\\b");//,Pattern.CASE_INSENSITIVE);
		//Pattern sep=Pattern.compile("[^\\W]");
		
		Scanner in=new Scanner(System.in);
		System.out.print("please input a string:");
		String sda=in.nextLine();
		in.close();
		Matcher mth=pat.matcher(sda);
		boolean tf=mth.find();
		while(tf)
		{
			String buffer=mth.group().toLowerCase();
			//Matcher sem=sep.matcher(buffer);
			
			numcount.put(buffer, numcount.get(buffer)==null?1:numcount.get(buffer)+1);
			tf=mth.find();
		}
	
		Set<String> countSet=numcount.keySet();
		
		//output
		Iterator<String> point=countSet.iterator();
		while(point.hasNext())
		{
			String value=(String)point.next();
			System.out.println(value+":"+numcount.get(value));
		}
	}
}
