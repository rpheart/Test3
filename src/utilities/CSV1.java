package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV1 {
	
	public static List<String[]> get(String filename){
		
		List<String[]> data = new ArrayList<String[]>();
		String testRow;
		
		try{
			BufferedReader br= new BufferedReader(new FileReader(filename));
			
			while ((testRow = br.readLine()) !=null) {
		String[] line = testRow.split(",");
		data.add(line);
			
			}
	}catch (FileNotFoundException e){
		System.out.println("Error :file not found" + filename);
		
	}catch (IOException e){
		System.out.println("Error :could not read " + filename);
	}
		return data;}}
	
		
	


