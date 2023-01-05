package patient.view;

import java.util.Scanner;

import patient.vo.Patient;

public class PatientView {

	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=^.^= 온라인 진료예약 시스템 =^.^=");
		System.out.println("1. 회원 정보 등록");
		System.out.println("2. 회원 로그인");
		System.out.println("3. 진료예약하기");
		System.out.println("4. 진료예약 내역 조회하기");
		System.out.println("5. 회원 정보 수정하기");
		System.out.println("6. 회원 정보 삭제하기");
		System.out.println("0. 프로그램 종료");
		System.out.print("번호를 입력하세요 : ");
		int select = sc.nextInt();
		return select;
	}

	public Patient inputPatient() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=>.<= 정보 등록을 시작합니다 =>.<=");
		System.out.print("아이디(ID) : ");
		String patientId = sc.next();
		System.out.print("비밀번호(PassWord) : ");
		String patientPwd = sc.next();
		System.out.print("이름 : ");
		String patientName = sc.next();
		System.out.print("생년월일(주민번호 앞 7자리) : ");
		int patientNo = sc.nextInt();
		System.out.print("진료과목([정형외과/내과] 입력가능) : ");
		String medicalCourse = sc.next();
		System.out.print("의사 선택([정형외과 = 김철수] [내과 = 김영희)] : ");
		String doctorName = sc.next();
		System.out.print("진료 구분(초진/재진) : ");
		String treatmentDivision = sc.next();
		System.out.print("진료 날짜 : ");
		int treatmentDate = sc.nextInt();

		Patient patient = new Patient(patientId, patientPwd, patientName, patientNo, medicalCourse, doctorName,
				treatmentDivision, treatmentDate);
		return patient;
	}

	public void displaySuccess(String message) {
		System.out.println("[성공]: " + message);
	}

	public void displayError(String message) {
		System.out.println("[실패]: " + message);
	}
	
	public Patient inputLoginInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("@_@로그인을 시작합니다.@_@");
		System.out.print("아이디: ");
		String patientId = sc.next();
		System.out.print("비밀번호: ");
		String patientPwd = sc.next();
		Patient patient = new Patient();
		patient.setPatientId(patientId);
		patient.setPatientPwd(patientPwd);
		return patient;
				
	}

	public Patient reservationTrmt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*^^ 진료 예약을 시작합니다.^^*");
		System.out.print("진료과목([정형외과/내과] 입력가능) : ");
		String medicalCourse = sc.next();
		System.out.print("의사 선택([정형외과 = 김철수] [내과 = 김영희)] : ");
		String doctorName = sc.next();
		System.out.print("진료 구분(초진/재진) : ");
		String treatmentDivision = sc.next();
		System.out.print("진료 날짜 : ");
		int treatmentDate = sc.nextInt();
		Patient patient = new Patient();
		return patient;
	}

}
