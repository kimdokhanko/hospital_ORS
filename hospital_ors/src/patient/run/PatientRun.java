package patient.run;

import java.util.List;

import patient.controller.PatientController;
import patient.view.PatientView;
import patient.vo.Patient;

public class PatientRun {
	public static void main(String[] args) {
		PatientView pView = new PatientView();
		PatientController pCon = new PatientController();
		List<Patient> pList = null;
		Patient patient = null;
		int result = 0;
		goodbye: while (true) {
			int choice = pView.mainMenu();
			switch (choice) {
			case 0: // 프로그램 종료 
				break goodbye;
			case 1: //회원 등록
				patient = pView.inputPatient();
				result = pCon.registerPatient(patient);
				if(result > 0) {
					pView.displaySuccess("정보 등록 완료");
				}else {
					pView.displayError("정보 등록 실패, 다시 시도해주세요.");
				}
				break;
			case 2: // 회원 로그인
				patient = pView.inputLoginInfo();
				result = pCon.checkInfo(patient);
				if(pList.size() > 0) {
					pView.displaySuccess("로그인 성공!");
				} else {
					pView.displayError("로그인 실패, 다시 시도 해주세요.");
				}
				break;
			case 3: // 진료예약하기
				patient = pView.reservationTrmt();
				result = pCon.RSVtreatment(patient);
				if(result > 0) {
					pView.displaySuccess("진료예약 성공!");
				} else {
					pView.displayError("진료예약이 완료되지 않았습니다. 다시 시도해주세요.");
				}
				break;
			case 4: // 진료예약 내역조회하기
				break;
			case 5: // 회원정보 수정하기 
				break;
			case 6: // 회원 정보 삭제하기
				break;
			}
		}
	}
}