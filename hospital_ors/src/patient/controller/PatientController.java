package patient.controller;

import java.util.List;

import patient.dao.PatientDAO;
import patient.vo.Patient;

public class PatientController {

	public int registerPatient(Patient patient) {
		PatientDAO pDao = new PatientDAO();
		int result = pDao.insertPatient(patient);
		return result;
	}

	public int checkInfo(Patient patient) {
		PatientDAO pDao = new PatientDAO();
		int result = pDao.checkLogin(patient);
		return result;
	}

	public int RSVtreatment(Patient patient) {
		PatientDAO pDao = new PatientDAO();
		int result = pDao.startRsv(patient);
		return result;
	}

	public Patient printById(String patientId) {
		PatientDAO pDao = new PatientDAO();
		Patient patient = pDao.selectById(patientId);
		return patient;
	}

	public int modifyPatientinfo(Patient patient) {
		PatientDAO pDao = new PatientDAO();
		int result = pDao.updatePatient(patient);
		return result;
	}

	public int removePatient(String patientId) {
		PatientDAO pDao = new PatientDAO();
		int result = pDao.deletePatient(patientId);
		return result;
	}
}
