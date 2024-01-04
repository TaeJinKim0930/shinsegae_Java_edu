package telbook.addressexception;
import telbook.Address;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Exception API Library
 * 유저의 입력 값을 필터링 할때 필요한 Exception List Library
 */
public class AddressExceptionList {


	/**
	 * 유저가 입력한 Email 값이 제대로 된 값인지 검증 하는 메소드
	 * Pattern p 에 regex 포멧을 설정한 후에, Matcher m 에 유저가 제공한 email 을
	 * mathcer() 메소드를 통해 변형을 해주고, matches() 를 통해 matcher에 설정한 포멧에 맞는지 확인을 해줍니다
	 *
	 * == Pattern.compile(String regex) ==
	 * Compiles the given regular expression into a pattern.
	 * Params:
	 * 		regex – The expression to be compiled
	 * Returns:
	 * 		the given regular expression compiled into a pattern
	 * Throws:
	 * 		PatternSyntaxException – If the expression's syntax is invalid
	 *
	 *
	 * == matcher(CharSequence input) ==
	 * Creates a matcher that will match the given input against this pattern.
	 * Params:
	 * 		input – The character sequence to be matched
	 * Returns:
	 * 		A new matcher for this pattern
	 *
	 *
	 * @param email : 유저의 입력값
	 * @return : true  --> 정상적인 Email 형식
	 * 			 false --> 비정상적인 Email 형식
	 */
	public static boolean isValidEmail(String email) {
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidNumber(String number) {
		String regex = "^[0-9]+(-)+[0-9]+(-)+[0-9]*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(number);
		if (m.matches()) {
			return false;
		}
		return true;
	}
	
	public static boolean isExistName(String name, Map<String, Address> people) {
		Set<String> keySet = people.keySet();
		for(String a : keySet) {
			if(name.equals(people.get(a).getName())) return true;
		}
		
		return false;
	}
	
	public static boolean isExistNumber(String number, Map<String, Address> people) {
		Set<String> keySet = people.keySet();
		for(String a : keySet) {
			if(number.equals(people.get(a).getPhonNumber())) return true;
		}
		return false;
	}
}
