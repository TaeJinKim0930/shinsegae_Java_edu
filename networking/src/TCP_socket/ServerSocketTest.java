package TCP_socket;

import java.io.*;
import java.net.ServerSocket;
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
public class ServerSocketTest {
    private static ServerSocket serverSocket = null;
    public static void main(String[] args) {

        try {
            // 서버소켓을 5050 포트로 생성
            ServerSocket serverSocket = new ServerSocket(5050);
            // 현재 위치에 생성한 소켓을 받을 준비하기
            Socket socket = serverSocket.accept();

            // 서버리더로 byte 형식으로 받기 위함
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 스트링에 값 넣어주기
            String msg = br.readLine();
            System.out.println(msg);

            /**
             * 서버 소켓은 호스트기때문에 닫지 않아도 에러가 발생하지 않는데
             * 클라이언트 소켓을 닫지 않는다면
             * 서버 소켓이 다음 클라이언트를 받을 수 없기때문에 에러를 발생 시키는 것
             * ex) 다음 손님 받아야 되니깐 빨리 가! 라는 느낌
             */
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
