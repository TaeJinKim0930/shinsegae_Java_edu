package telbook;

public class Address {

	private String name;
	private String phonNumber;
	private String email;
	
	Address(){}
	public Address(String n, String p, String e) {
		this.name = n;
		this.phonNumber = p;
		this.email = e;
	} //생성자
	public String getName() {
		return name;
	}
	public String getPhonNumber() {
		return phonNumber;
	}
	public String getEmail() {
		return email;
	}
	//getter

	public Address inputPhonnumber(String n, String p, String e) {
		Address people = new Address(n, p, e);
		System.out.println("입력하신 정보가 저장되었습니다.");
		return people;
	}
	
}
