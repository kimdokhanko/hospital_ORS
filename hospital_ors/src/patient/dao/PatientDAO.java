package patient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patient.vo.Patient;

public class PatientDAO {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "student";
	private final String PASSWORD = "student";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	public int insertPatient(Patient patient) {
		int result = 0;
		String sql = "INSERT INTO HOSPITAL_TBL(PATIENT_ID, PATIENT_PWD, PATIENT_NAME, PATIENT_NO) VALUES(?,?,?,?)";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, patient.getPatientId());
			pstmt.setString(2, patient.getPatientPwd());
			pstmt.setString(3, patient.getPatientName());
			pstmt.setInt(4, patient.getPatientNo());

			result = pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int checkLogin(Patient patient) {
		String query = "SELECT COUNT(*) AS P_COUNT FROM HOSPITAL_TBL WHERE PATIENT_ID=? AND PATIENT_PWD=?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, patient.getPatientId());
			pstmt.setNString(2, patient.getPatientPwd());
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("P_COUNT");
			}
			pstmt.close();
			conn.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int startRsv(Patient patient) {
		String sql = "UPDATE FROMHOSPITAL_TBL SET MEDICAL_COURSE=?, DOCTOR_NAME=?, TREATMENT_DIVISION=?, TREATMENT_DATE=?, WHERE PATIENT_ID=?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, patient.getMedicalCourse());
			pstmt.setString(2, patient.getDoctorName());
			pstmt.setString(3, patient.getTreatmentDivision());
			pstmt.setInt(4, patient.getTreamentDate());
			ResultSet rset = pstmt.executeQuery();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Patient selectById(String patientId) {
		Patient patient = null;
		String sql = "SELECT * FROM HOSPITAL_TBL WHERE PATIENT_ID=?";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, patientId);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				patient = new Patient();
				patient.setPatientId(rset.getString("PATIENT_ID"));
				patient.setPatientPwd(rset.getString("PATIENT_PWD"));
				patient.setPatientName(rset.getString("PATIENT_NAME"));
				patient.setPatientNo(rset.getInt("PATIENT_NO"));
				patient.setMedicalCourse(rset.getString("MEDICAL_COURSE"));
				patient.setDoctorName(rset.getString("DOCTOR_NAME"));
				patient.setTreatmentDivision(rset.getString("TREATMENT_DIVISION"));
				patient.setTreamentDate(rset.getInt("TREATMENT_DATE"));
			}
			pstmt.close();
			conn.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patient;
	}

	public int updatePatient(Patient patient) {
		int result = 0;
		String sql = "UPDATE HOSPITAL_TBL PATIENT_PWD = ?";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, patient.getPatientPwd());
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deletePatient(String patientId) {
		String sql = "DELETE FROM PATIENT_TBL WHERE PATIENT_ID = ?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, patientId);
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
