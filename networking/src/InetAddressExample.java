import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소: " + local.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com"); // naver 의 host 를 가져오기

            // DNS (Domian Name System)
            for(InetAddress remote : iaArr) {
                System.out.println("www.naver.com IP 주소: " + remote.getHostAddress());
            }
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
    }
}