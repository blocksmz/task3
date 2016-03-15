import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class countchav2 {

	public static void main(String[] args)
	{
		Map<String,Integer> numcount=new HashMap<String,Integer>();	
		//regex
		Pattern pat=Pattern.compile("\\b[A-Za-z][A-Za-z0-9]{3,}\\b");
		
		try{
		BufferedReader in=new BufferedReader(new FileReader("becauseofyou.txt"));
		String temp;
		while((temp=in.readLine())!=null)
		{
			Matcher mth=pat.matcher(temp);
			boolean tf=mth.find();
			while(tf)
			{
				String buffer=mth.group().toLowerCase();
				
				numcount.put(buffer, numcount.get(buffer)==null?1:numcount.get(buffer)+1);
				tf=mth.find();
			}
		}
				
		in.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("Cannot find the specified file");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
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
