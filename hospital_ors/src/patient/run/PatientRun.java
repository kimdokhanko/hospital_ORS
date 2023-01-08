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
		String patientId = "";
		int result = 0;
		goodbye: while (true) {
			int choice = pView.mainMenu();
			switch (choice) {
			case 0: // 프로그램 종료
				break goodbye;
			case 1: // 회원 등록
				patient = pView.inputPatient();
				result = pCon.registerPatient(patient);
				if (result > 0) {
					pView.displaySuccess("정보 등록 완료");
				} else {
					pView.displayError("정보 등록 실패, 다시 시도해주세요.");
				}
				break;
			case 2: // 회원 로그인
				patient = pView.inputLoginInfo();
				result = pCon.checkInfo(patient);
				if (pList.size() > 0) {
					pView.displaySuccess("로그인 성공!");
				} else {
					pView.displayError("로그인 실패, 다시 시도 해주세요.");
				}
				break;
			case 3: // 진료예약 변경하기
				patient = pView.reservationTrmt();
				result = pCon.RSVtreatment(patient);
				if (result > 0) {
					pView.displaySuccess("진료예약 변경성공!");
				} else {
					pView.displayError("진료예약이 변경되지 않았습니다. 다시 시도해주세요.");
				}
				break;
			case 4: // 아이디로 진료예약 내역조회하기
				patientId = pView.inputPatientId("검색");
				patient = pCon.printById(patientId);
				if (patient != null) {
					pView.showOne(patient);
				} else {
					pView.displayError("일치하는 아이디가 없습니다. 다시 조회해주세요.");
				}
				break;
			case 5: // 회원정보 수정하기 (비밀번호 변경)
				patientId = pView.inputPatientId("수정");
				patient = pCon.printById(patientId);
				if (patient != null) {
					patient = pView.modifyPatient(patientId);
					result = pCon.modifyPatientinfo(patient);
					if (result > 0) {
						pView.displaySuccess("회원 정보 수정 완료");
					} else {
						pView.displayError("정보 수정에 실패하였습니다. 다시 시도해 주세요.");
					}
				}
				break;
			case 6: // 회원 정보 삭제하기
				patientId = pView.inputPatientId("삭제");
				result = pCon.removePatient(patientId);
				if(result > 0) {
					pView.displaySuccess("회원 정보 삭제가 완료 되었습니다.");
				} else {
					pView.displayError("회원 정보 삭제가 실패하였습니다. 다시 시도해 주세요.");
				}
				break;
			}
		}
	}
}