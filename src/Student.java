
public class Student implements Student_ {
	String fname;
	String lname;
	String hostel;
	String department;
	String cgpa;
	Student(String f, String l, String h, String d, String c){
		fname = f;
		lname = l;
		hostel = h;
		department = d;
		cgpa = c;
	}
	@Override
	public String fname() {
		return fname;
	}

	public String lname() {
		return lname;
	}

	public String hostel() {
		return hostel;
	}

	public String department() {
		return department;
	}

	public String cgpa() {
		return cgpa;
	}

	public String toString() {
		return fname + " " + lname + " " + hostel + " " + department + " " + cgpa;
	}
}
