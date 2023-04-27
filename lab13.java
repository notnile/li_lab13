import java.util.Arrays;
import java.util.stream.IntStream;

public class lab13 {
	private java.util.ArrayList<Integer> arr; 
	
	public lab13() {
		arr = new java.util.ArrayList<Integer>();
	}
	public void readData(String filename) {
		java.io.File inputFile = new java.io.File(filename);
		java.io.BufferedReader reader;
		try {
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFile)));
			String str;
			while((str = reader.readLine()) != null) {
				arr.add(Integer.parseInt(str));
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public long getTotalCount() {
		return arr.stream().count();
	}
	public long getOddCount() {
		return arr.stream().filter(w -> (w&1)== 1).count();
	}
	public long getEvenCount() {
		return arr.stream().filter(w -> (w&1)== 0).count();
	}
	public long getDistinctGreaterThanFiveCount() {
		return arr.stream().filter(w -> (w>5)).distinct().count();
	}
	public Integer[] getResult1() {
		return arr.stream().filter(w -> (((w&1) == 0) && (w>5) && (w<50))).sorted().toArray(Integer[] :: new);
	}
	public Integer[] getResult2() {
		return IntStream.of(arr.stream().limit(50).mapToInt(w -> (w*w*3)).toArray()).boxed().toArray(Integer[] :: new);
	}
	public Integer[] getResult3() {
		return IntStream.of(arr.stream().filter(w -> (w&1)==1).mapToInt(w -> (w*2)).sorted().skip(20).distinct().toArray()).boxed().toArray(Integer[] :: new);
	}
	
}
