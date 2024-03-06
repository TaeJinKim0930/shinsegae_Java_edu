import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class readJSON {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("member.json", Charset.forName("UTF-8")));
        String data = br.readLine();
        br.close();

        // JSON 파싱
        JSONObject root = new JSONObject(data);
        // 아이디값만 출력
        System.out.println(root.getString("id"));
        // 전체 출력
        System.out.println(root);

        // JSON object 받아오기
        JSONObject contact = root.getJSONObject("contact");
        System.out.println(contact.getString("home"));

        // 배열속성
        JSONArray jsonArray = root.getJSONArray("hobby");
        jsonArray.forEach(System.out::println);

    }
}
