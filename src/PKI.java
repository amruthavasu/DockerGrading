import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PKI implements LabInterface{
	private static final String SCRIPT_PATH = "/root/PKI_lab/pki_grading.sh ";
	private static final String SEARCH_TERM = "Issuer: commonName=ManagementCA/organizationName=EJBCA/";
	
	@Override
	public int grade(Student student) {
		// TODO Auto-generated method stub
		int result = 0;
		if (!student.getReposiory().equals("") || student.getReposiory() != null) {
			String target = new String(SCRIPT_PATH + student.getReposiory());
			try {
				Runtime rt = Runtime.getRuntime();
				Process proc = rt.exec(target);
				proc.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				String line = "";
				while ((line = reader.readLine()) != null) {
					if (line.contains(SEARCH_TERM)) {
						result = 100;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
