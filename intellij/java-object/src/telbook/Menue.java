package telbook;

import telbook.addressexception.AddressException;
import telbook.addressexception.AddressExceptionList;
import telbook.addressexception.ErrorCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class Menue {
	Scanner sc = new Scanner(System.in);

	public Map<String, Address> addressBook = new HashMap<>();

	AddressExceptionList error = new AddressExceptionList();
	Menue() {
	}

	public void showMenue() {
		System.out.println("[메뉴 선택]");
		System.out.println("1.전화번호 입력");
		System.out.println("2.전체 주소록 조회");
		System.out.println("3.전화번호 조회");
		System.out.println("4.전화번호 수정");
		System.out.println("5.전화번호 삭제");
		System.out.println("6.종료");
		System.out.print("선택 : ");
	} // 메뉴 보기

	public void choiceMenue(String num) {
		switch (num) {
			case "1" :
				Address p = inputPhone();
				addressBook.put(p.getName(), p);
				break;
			case "2" :
				showAllPhone();
				break;
			case "3" :
				System.out.print("\n조회할 이름: ");
				String name = sc.next();
				showPhone(name);
				break;
			case "4" :
				System.out.print("\n수정할 정보의 이름: ");
				name = sc.next();
				if (addressBook.containsKey(name)) {
					p = modifyAddress(name);
					addressBook.put(name, p);
				} else {
					System.out.println(name + "의 정보가 주소록에 존재하지 않습니다.");
				}
				break;
			case "5" :
				System.out.print("\n삭제할 이름: ");
				name = sc.next();
				deletePhone(name);
				break;
			case "6" :
				exit();
				break;
			default :
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
		}
	}// 메뉴 선택

	public Address inputPhone() {
		Address address = new Address();
		while (true) {
			try {
				System.out.print("\n이름을 입력해주세요 : ");
				String name = sc.next();
				if (addressBook.size() != 0
						&& error.isExistName(name, addressBook)) {
					throw new AddressException(ErrorCode.EXISTS_ALREADY_NAME);
				} // 존재하는 이름인지 유효성 검사 / 주소록에 1개 이상 존재해야 검사.., null 방지

				System.out.print("\n전화번호를 입력해주세요(형식: 010-1234-5678) : ");
				String phonNumber = sc.next();
				if (error.isValidNumber(phonNumber)) {
					throw new AddressException(
							ErrorCode.INVALID_INPUT_PHONENUMBER);
				} // 입력 전화번호 형식 확인, 000-00000-00000..
				if (addressBook.size() != 0
						&& error.isExistNumber(phonNumber, addressBook)) {
					throw new AddressException(
							ErrorCode.EXISTS_ALREADY_PHONENUMBER);
				} // 존재하는 번호인지 유효성 검사 / 주소록에 1개 이상 존재해야 검사.., null 방지

				System.out.print("\n이메일을 입력해주세요 : ");
				String email = sc.next();
				if (error.isValidEmail(email)) {
					throw new AddressException(ErrorCode.INVALID_INPUT_EMAIL);
				} // 이메일 형식 확인 abcd@abcd.abcd

				System.out.println(name + "/" + phonNumber + "/" + email
						+ "이 맞습니까?\n재 입력을 원하면 아무키, 등록을 원하면 Y을 입력해주세요.");
				String a = sc.next();

				if (a.equalsIgnoreCase("Y")) {
					return address.inputPhonnumber(name, phonNumber, email);
				} else
					continue;
				// 입력 재 확인, 다시 입력하고 싶으면 아무키나 ..

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
	} // 전화번호 입력 메소드

	public Address modifyAddress(String name) {
		Address address = new Address();
		while (true) {
			try {
				System.out.println(name + "의 정보를 수정합니다.(전화번호, 이메일 수정 가능)");

				System.out.print("수정할 전화번호를 입력하세요(변경을 원하지 않으시면 y 입력) : ");
				String phonNumber = sc.next();
				if (phonNumber.equalsIgnoreCase("Y")) {
					phonNumber = addressBook.get(name).getPhonNumber();
				} else {
					if (error.isValidNumber(phonNumber)) {
						throw new AddressException(
								ErrorCode.INVALID_INPUT_PHONENUMBER);
					} // 입력 전화번호 형식 확인, 000-00000-00000..
					if (addressBook.size() != 0
							&& error.isExistNumber(phonNumber, addressBook)) {
						throw new AddressException(
								ErrorCode.EXISTS_ALREADY_PHONENUMBER);
					} // 존재하는 번호인지 유효성 검사 / 주소록에 1개 이상 존재해야 검사.., null 방지
				}

				System.out.print("수정할 이메일을 입력하세요(변경을 원하지 않으시면 y 입력) : ");
				String email = sc.next();
				if (phonNumber.equalsIgnoreCase("Y")) {
					phonNumber = addressBook.get(name).getEmail();
				} else {
					if (error.isValidEmail(email)) {
						throw new AddressException(
								ErrorCode.INVALID_INPUT_EMAIL);
					} // 이메일 형식 확인 abcd@abcd.abcd
				}
				
				return address.inputPhonnumber(name, phonNumber, email);
				
			} catch (Exception e) {
				// e.printStackTrace();

			}
		}
	}//전화번호 수정 메소드

	public void showAllPhone() {
		try {
			if (addressBook.isEmpty()) {
				System.out.println("주소록에 전화번호가 존재하지 않습니다.(adress_book_empty)");
				return;
			} // 주소록이 비어있는 경우
			System.out.println("====전체 전화번호 출력====");

			int cnt = 0;
			Set<String> keyset = addressBook.keySet();
			Iterator<String> keIterator = keyset.iterator();
			while (keIterator.hasNext()) {
				cnt++;
				String k = keIterator.next();
				System.out.printf(
						"%d번째 번호%nName : %s%nPhoneNumber : %s%nEmail : %s%n%n",
						cnt, addressBook.get(k).getName(),
						addressBook.get(k).getPhonNumber(),
						addressBook.get(k).getEmail());
			}
			System.out.println("=====================");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	} // 전체 주소록 보기

	public void showPhone(String name) {
		try {
			String key = name;
			int cnt = 0;
			Set<String> keyset = addressBook.keySet();
			Iterator<String> keIterator = keyset.iterator();
			while (keIterator.hasNext()) {
				String k = keIterator.next();
				if (k.equals(key)) {
					System.out.printf(
							"%nName : %s%nPhoneNumber : %s%nEmail : %s%n",
							addressBook.get(k).getName(),
							addressBook.get(k).getPhonNumber(),
							addressBook.get(k).getEmail());
					cnt++;
				} else
					continue;
			}
			if (cnt == 0) {
				throw new AddressException(
						ErrorCode.ADDRESSBOOK_NO_INFORMATION);
			} // cnt==0은 입력한 이름의 번호가 주소록에 없음, 존재하지 않는 전화번호 예외처리
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}// 전화번호 개별 검색 메소드

	public void deletePhone(String name) {
		try {
			String key = name;
			int cnt = 0;
			Set<String> keyset = addressBook.keySet();
			for (String a : keyset) {
				if (a.equals(name)) {
					addressBook.remove(a);
					cnt++;
					System.out.println(name + "의 번호가 삭제되었습니다.");
				}
			}
			if (cnt == 0) {
				throw new AddressException(
						ErrorCode.ADDRESSBOOK_NO_INFORMATION);
			} // cnt==0은 입력한 이름의 번호가 주소록에 없음, 존재하지 않는 전화번호 예외처리
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}// 전화번호 삭제 메소드

	public void exit() {
		System.out.println("주소록 시스템이 종료합니다.");
		System.exit(0);
	}// 프로그램 종료 메소드
}
