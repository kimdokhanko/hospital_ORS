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
		String sql = "INSERT INTO HOSPITAL_TBL VALUES(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, patient.getPatientId());
			pstmt.setString(2, patient.getPatientPwd());
			pstmt.setString(3, patient.getPatientName());
			pstmt.setInt(4, patient.getPatientNo());
			pstmt.setString(5, patient.getMedicalCourse());
			pstmt.setString(6, patient.getDoctorName());
			pstmt.setString(7, patient.getTreatmentDivision());
			pstmt.setInt(8, patient.getTreamentDate());

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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int startRsv(Patient patient) {
		String sql = "SELECT * FROMHOSPITAL_TBL WHERE MEDICAL_COURSE=?, DOCTOR_NAME=?, TREATMENT_DIVISION=?, TREATMENT_DATE=?";
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

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
