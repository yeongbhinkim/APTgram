package com.project.apt.ConnectionTestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/apt")
public class ConnectionTestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET) // GET 요청으로 변경
    public String testConnection() {
        System.out.print("접속");
        try {
//            URL url = new URL("http://localhost:9080/apt/test"); // URL 변경 확인 필요
            URL url = new URL("http://localhost:9081/testTest"); // URL 변경 확인 필요
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.print("성공");
                return "연결 성공: " + response.toString();
            } else {
                System.out.print("실패");
                return "연결 실패: " + responseCode;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("오류");
            return "연결 중 오류 발생";
        }
    }
}
