package TCP_socket;

import java.io.*;
import java.net.Socket;
/**
 * === How to Execute ===
 * 1. Run ServerSocketTest
 * 2. Run ClientSockentTest
 * 3. msg will be printed in ServerSocketTest that was previously executed
 *
 * 서버소켓 생성
 * 클라이언트의 소켓과 접속 할 수 있도록 accept 서버소켓에 바인드
 * 클라이언트가 보낸 데이터 받기
 * 클라이언트에 메세지 보내기
 * 소켓종료
 * 서버소켓 종료
 */
public class ClientSocketTest {
    public static void main(String[] args) {
        try {
            // 목적지인 아아피주소(로컬호스트)과 연결을 할 포트번호 5050 번으로 송신
            Socket socket = new Socket("127.0.0.1", 5050);
            // 해당 소켓에 BufferedWriter 로 byte 타입으로 송신을 준비
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 값 전송
            bw.write("A");
            // 혹시모르게 쌓여있을 버퍼 제거
            bw.flush();
            // 서버 닫아 버리기
            /**
             * 클라이언트 서버를 닫지 않아주면 서버 쪽에서 해당 소켓 에러가 뜸
             * java.net.SocketException: Connection reset
             */
            System.out.println();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
