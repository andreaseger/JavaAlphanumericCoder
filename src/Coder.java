import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;

public class Coder {

	static Set<String> codes = new HashSet<String>();

	private static long generate(long count){
		for(int i = 0;i<count;i++){
			codes.add(RandomStringUtils.randomAlphanumeric(10));
		}
		return codes.size();
	}
	
	private static void write_to_csv(int per_row){
		try
		{
		  FileWriter writer = new FileWriter("codes.csv");
		  Iterator<String> it = codes.iterator();
		  while(it.hasNext())
		  {
		     for(int i = 0; i < per_row && it.hasNext(); i++)
		     {
		        writer.append(it.next());
		        if(i < per_row - 1)
		           writer.append(',');
		     }
		     writer.append('\n');
		  }
			writer.flush();
			writer.close();
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
	}
	private static void generate_and_save(int count, int per_row){
		try {
			FileWriter writer = new FileWriter("codes.csv");
			for(int i = 0;i<count;i++){
				writer.append(RandomStringUtils.randomAlphanumeric(10));
				if(i%per_row == 0)
					writer.append('\n');
				else
					writer.append(',');
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count=0;
		int per_row=10;
		try{
			switch (args.length) {
			case 0:
				System.out.println("Parameter fehlen: <count> <per_row>");
				break;
			case 1:
				System.out.println("es wird 10 als Anzahl der Codes pro Zeile verwendet");
				count = Integer.parseInt(args[0]);
			case 2:
				count = Integer.parseInt(args[0]);
				per_row = Integer.parseInt(args[1]);
			}
		}catch (NumberFormatException  e) {
			e.printStackTrace();
		}
		//generate(count);
		//write_to_csv(per_row);
		generate_and_save(count, per_row);
	}
}
