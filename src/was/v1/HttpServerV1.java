package was.v1;

import static java.nio.charset.StandardCharsets.*;
import static threaad.util.MyLogger.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerV1 {

  private final int port;

  public HttpServerV1(int port) {
    this.port = port;
  }

  public void start() throws IOException {
    // 클라이언트와 연결을 수락할 준비가 되어있는 서버 소캣, 즉 서버역할을 하는 객체임. 해당 port 에서 연결 기다리는 것임.
    ServerSocket serverSocket = new ServerSocket(port);

    log("Server 시작 port: " + port);

    while (true) {
      // 클라이언트가 연결 요청할 때까지 블로킹됨. 클라이언트가 연결 요청하면 그 요청 수락하고 socket 객체를 반환함.
      Socket socket = serverSocket.accept();
      process(socket);
    }
  }

  private void process(Socket socket) throws IOException {
    try (socket;
        // 바이트 기반을 문자 기반으로 변환하면서 편하게 입출력하도록 래핑한 것.
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(socket.getInputStream(), UTF_8));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)) {
      String requestString = requestToString(reader);
      if (requestString.contains("/favicon.ico")) {
        log("favicon 요청");
        return;
      }

      log("HTTP 요청 정보 출력");
      System.out.println(requestString);

      log("HTTP 응답 생성 중...");
      sleep(5000);
      responseToClient(writer);
      log("HTTP 응답 전달 완료");

    }

  }

  private void responseToClient(PrintWriter writer) {
    //웹 브라우저에 응답 전달하는 내용
    String body = "<h1>Hello World</h1>";
    int length = body.getBytes(UTF_8).length;
    StringBuilder sb = new StringBuilder();
    sb.append("HTTP/1.1 200 OK\r\n");
    sb.append("Content-Type: text/html\r\n");
    sb.append("Content-Length: " + length + "\r\n");
    sb.append("\r\n");
    sb.append(body);

    log("HTTP 응답 정보 출력");
    System.out.println(sb);

    writer.println(sb);
    writer.flush();
  }

  private String requestToString(BufferedReader reader) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      if (line.isEmpty()) {
        break;
      }
      sb.append(line).append("\n");
    }
    return sb.toString();
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
