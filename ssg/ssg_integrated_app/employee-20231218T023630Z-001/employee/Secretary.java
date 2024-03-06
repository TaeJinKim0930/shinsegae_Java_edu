package employee;

public class Secretary extends Staff {
	
	public Secretary(String strENo, String strName, int nYear, int nMonth, int nDate) {
		super(strENo, strName, nYear, nMonth, nDate);
		super.setRole("Secretary");
		super.setNowPay(super.getPay());
	}
}