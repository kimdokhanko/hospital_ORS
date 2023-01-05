package patient.vo;

public class Patient {
	private String patientId;
	private String patientPwd;
	private String patientName;
	private int patientNo;
	private String medicalCourse;
	private String doctorName;
	private String treatmentDivision;
	private int treatmentDate;

	public Patient() {
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientPwd=" + patientPwd + ", patientName=" + patientName
				+ ", patientNo=" + patientNo + ", medicalCourse=" + medicalCourse + ", doctorName=" + doctorName
				+ ", treatmentDivision=" + treatmentDivision + ", treatmentDate=" + treatmentDate + "]";
	}

	public Patient(String patientId, String patientPwd, String patientName, int patientNo, String medicalCourse,
			String doctorName, String treatmentDivision, int treamentDate) {
		super();
		this.patientId = patientId;
		this.patientPwd = patientPwd;
		this.patientName = patientName;
		this.patientNo = patientNo;
		this.medicalCourse = medicalCourse;
		this.doctorName = doctorName;
		this.treatmentDivision = treatmentDivision;
		this.treatmentDate = treamentDate;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientPwd() {
		return patientPwd;
	}

	public void setPatientPwd(String patientPwd) {
		this.patientPwd = patientPwd;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	public String getMedicalCourse() {
		return medicalCourse;
	}

	public void setMedicalCourse(String medicalCourse) {
		this.medicalCourse = medicalCourse;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getTreatmentDivision() {
		return treatmentDivision;
	}

	public void setTreatmentDivision(String treatmentDivision) {
		this.treatmentDivision = treatmentDivision;
	}

	public int getTreamentDate() {
		return treatmentDate;
	}

	public void setTreamentDate(int treamentDate) {
		this.treatmentDate = treamentDate;
	}

}
