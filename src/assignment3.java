import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class assignment3 {

	public static void main(String[] args) throws IOException {
		int hashtablesize = Integer.valueOf(args[0]);
		String hashtabletype = args[1];
		String filelocation = args[2];
	
		MyHashTable_<Pair<String, String>, Student> h = null;
		if(hashtabletype.equals("DH")) {
			h = new MyHashTable1<Pair<String, String>, Student>(hashtablesize);
		}
		else if(hashtabletype.equals("SCBST")) {
			h = new MyHashTable2<Pair<String, String>, Student>(hashtablesize);
		}
		else {
			System.out.println("Invalid input");
			return;
		}
		BufferedReader br = null;
		String line;
		br =  new BufferedReader(new FileReader(filelocation));
		while((line = br.readLine()) != null) {
			try {
				String[] arr = line.split(" ");
				Pair<String, String> p = new Pair<String, String>(arr[1], arr[2]);
				if(arr[0].equals("insert")) {
					Student s = new Student(arr[1], arr[2], arr[3], arr[4], arr[5]);
					int x = h.insert(p, s);
					if(x != 0) {
						System.out.println(x);
					}
					else {
						System.out.println("E");
					}
				}
				else if(arr[0].equals("update")) {
					Student s = new Student(arr[1], arr[2], arr[3], arr[4], arr[5]);
					int x = h.update(p, s);
					if(x != 0) {
						System.out.println(x);
					}
					else {
						System.out.println("E");
					}
				}
				else if(arr[0].equals("delete")) {
					int x = h.delete(p);
					if(x != 0) {
						System.out.println(x);
					}
					else {
						System.out.println("E");
					}
				}
				else if(arr[0].equals("contains")) {
					if(h.contains(p)) {
						System.out.println("T");
					}
					else {
						System.out.println("F");
					}
				}
				else if(arr[0].equals("get")) {
					System.out.println(h.get(p).toString());
				}
				else if(arr[0].equals("address")) {
					System.out.println(h.address(p));
				}
			}
			catch (NotFoundException e){
				System.out.println("E");
			}
		}
		br.close();
	}
}