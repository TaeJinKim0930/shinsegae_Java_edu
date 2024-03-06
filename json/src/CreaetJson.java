import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

public class CreaetJson {
    public static void main(String[] args) throws IOException {
        // JSON 객체 생성
        JSONObject obj = new JSONObject();
        JSONObject tel = new JSONObject();
        JSONArray hobby = new JSONArray();

        // JSON 객체에 속성 추가
        obj.put("id", "sin");
        obj.put("pw",1234);
        obj.put("student", true);

        tel.put("home", "02-000-0777");
        tel.put("mobile", "010-7777-7777");
        obj.put("contact", tel);

        hobby.put("swimming");
        hobby.put("golfing");
        obj.put("hobby", hobby);

        // 속성 확인하기
        String data = obj.toString();

        // 콘솔에 출력
        System.out.println(data);

        // 파일에 저장
        Writer writer = new FileWriter("member.json", Charset.forName("UTF-8"));
        writer.write(data);
        writer.flush();
        writer.close();



    }
}
