package demos;

import java.util.List;

public class DataReaders {
	
	public static void main (String []args){
		
		readCSV();
	}public static void readCSV(){
		String filename="C:\\CSV\\Account.csv";
				List <String[]> records=utilities.CSV1.get(filename);
				
				//iterating through list
				for (String[] record : records) {
					for (String field : record ) {
							
							System.out.println(field);
					}
				}
				
		
	}

}
