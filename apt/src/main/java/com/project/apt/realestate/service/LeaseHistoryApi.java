package com.project.apt.realestate.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.apt.realestate.dto.LeaseHistoryResponseDto;
import com.project.apt.realestate.dto.LeaseHistoryResponseDto.TbLnOpendataRentV.InnerRow;
import com.project.apt.realestate.repository.LeaseHistoryRepository;
import com.project.apt.realestate.util.CustomTrxUtil;
import com.project.apt.realestate.vo.LeaseHistoryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static com.project.apt.realestate.util.CustomTrxUtil.generateCurrentTime;
import static com.project.apt.realestate.util.CustomTrxUtil.generateTrxNo;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LeaseHistoryApi {

	private final ObjectMapper objectMapper;
	private final LeaseHistoryRepository leaseHistoryRepository;

	@GetMapping("/api2")
	public void getTradeHistory() throws IOException {

		String startTime = generateCurrentTime(); // 현재 시간을 밀리세컨드까지 구한다.
		String trxNo = generateTrxNo(startTime); // 트랜잭션 번호를 생성한다.
		log.info("[{}] ========== {} START ==========", trxNo, this.getClass().getSimpleName());

		// 공공데이터 Open API 요청에 사용할 URL을 조립한다.
		// 이하 필수값
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); // URL
		urlBuilder.append("/" + URLEncoder.encode("7741447056666f6f35304365597842","UTF-8") ); // 인증키
		urlBuilder.append("/" + URLEncoder.encode("json","UTF-8") ); // 요청파일타입
		urlBuilder.append("/" + URLEncoder.encode("tbLnOpendataRentV","UTF-8")); // 서비스명
		urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); // 요청시작위치 (페이징 시작 번호)
		urlBuilder.append("/" + URLEncoder.encode("10","UTF-8")); // 요청종료위치 (페이징 끝 번호)

		// 이하 선택값
		urlBuilder.append("/" + URLEncoder.encode("2023","UTF-8"));
		log.info("[{}] API URL: {}", trxNo, urlBuilder);

		// http 통신으로 API를 요청한다.
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		log.info("[{}] API RESPONSE CODE: {}", trxNo, conn.getResponseCode());

		// API 응답 데이터를 받는다.
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		// API 응답 데이터를 StringBuilder에 담는다.
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}

		// http 연결을 종료한다.
		rd.close();
		conn.disconnect();

		// 응답 데이터를 Dto 객체로 파싱한다.
		String responseBody = sb.toString();
		LeaseHistoryResponseDto leaseHistoryResponseDto = objectMapper.readValue(responseBody, LeaseHistoryResponseDto.class);
		InnerRow[] row = leaseHistoryResponseDto.getTbLnOpendataRentV().getRow();

		// Dto 객체에 담긴 응답 데이터를 실제 VO 객체에 매핑한다.
		List<LeaseHistoryVO> leaseHistoryVOList = new ArrayList<>();
		for (InnerRow innerRow : row) {
			LeaseHistoryVO leaseHistoryVO = LeaseHistoryVO.createFromJson(innerRow);
			leaseHistoryVOList.add(leaseHistoryVO);
		}

		// VO 객체를 DB에 저장한다.
		leaseHistoryRepository.saveAll(leaseHistoryVOList);

		log.info("[{}] 가져온 데이터 수 = {}", trxNo, leaseHistoryVOList.size());
		log.info("[{}] 가져온 데이터 = {}", trxNo, leaseHistoryVOList);

		String endTime = generateCurrentTime(); // 현재 시간을 밀리세컨드까지 구한다.
		long trxTime = CustomTrxUtil.calculateTrxTime(startTime, endTime); // API 트랜잭션 소요 시간을 구한다.
		log.info("[{}] 소요시간: {}", trxNo, trxTime);
		log.info("[{}] ========== {} END ==========", trxNo, this.getClass().getSimpleName());
	}
}