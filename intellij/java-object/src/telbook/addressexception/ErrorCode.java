package telbook.addressexception;

public enum ErrorCode implements EnumModel {

	/**
	 * 에러코드 출력을 위한 ENUM 값
	 */
	INVALID_INPUT_EMAIL(400, "유효하지 않는 이메일 형식입니다.", "E001"),
	INVALID_INPUT_PHONENUMBER(400, "유효하지 않는 전화번호 형식입니다.", "P001"),
	EXISTS_ALREADY_NAME(400, "이미 주소록에 존재하는 이름입니다.", "N001"),
	EXISTS_ALREADY_PHONENUMBER(400, "이미 주소록에 존재하는 번호입니다.", "P002"),
	ADDRESSBOOK_NO_INFORMATION(404, "주소록에 존재하지 않는 정보입니다.", "N002");

	/**
	 * ENUM 값에서 status, message, code 등을 빼내오기 위해 필요한 필드값
	 */
	private  int status;
	private  String message;
	private  String code;

	
	ErrorCode(int status, String message, String code) {
		this.status = status;
		this.message = message;
		this.code = code;
	}

	/**
	 * Getters
	 */
	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public String getCode() {
		return this.code;
	}
	
	public int getStatus() {
		return this.status;
	}

}
