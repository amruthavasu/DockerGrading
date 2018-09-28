import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Grade {
	private static final String INPUT_FILE = "dockerrepos.csv";
	private static final String OUTPUT_FILE = "grade.csv";
	
	public static void main(String args[]) {
		try {
			// Read input from file
			BufferedReader input = new BufferedReader(new FileReader(INPUT_FILE));
			BufferedWriter output = new BufferedWriter(new FileWriter(OUTPUT_FILE));
			String line1 = "";
			while ((line1 = input.readLine()) != null) {
				String tmp[] = line1.split(",");
				Student student = new Student();
				student.setFirstName(tmp[0]);
				student.setLastName(tmp[1]);
				int result;
				if (tmp.length > 2) {
					student.setReposiory(tmp[2]);
					LabInterface lab = new PKI();
					result = lab.grade(student);
				} else {
					result = 0;
				}				
				output.write(student.getFirstName() + student.getLastName() + student.getReposiory() + result);
			}
			input.close();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
