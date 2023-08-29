package com.project.apt.realestate.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.apt.realestate.dto.TradeHistoryResponseDto;
import com.project.apt.realestate.dto.TradeHistoryResponseDto.TbLnOpendataRtmsV.InnerRow;
import com.project.apt.realestate.repository.TradeHistoryRepository;
import com.project.apt.realestate.vo.TradeHistoryVO;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TradeHistoryApi {

	private final TradeHistoryRepository tradeHistoryRepository;

	@GetMapping("/api")
	public void getTradeHistory() throws IOException {

		LocalDateTime startLocalDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		String startTime = formatter.format(startLocalDateTime);
		Random random = new Random();
		String digits4 = String.valueOf(random.nextInt(90) + 10);
		String trxNo = startTime.toString() + digits4;
		log.info("[{}] [{}] ========== getTradeHistory START ==========", trxNo, startTime);

		// 공공데이터 Open API 요청에 사용할 URL을 조립한다.
		// 이하 필수값
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); // URL
		urlBuilder.append("/" +  URLEncoder.encode("7741447056666f6f35304365597842","UTF-8") ); // 인증키
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); // 요청파일타입
		urlBuilder.append("/" + URLEncoder.encode("tbLnOpendataRtmsV","UTF-8")); // 서비스명
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

		// API 성공여부를 확인한다.
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

		String responseBody = sb.toString();
		ObjectMapper objectMapper = new ObjectMapper();

		TradeHistoryResponseDto tradeHistoryResponseDto = objectMapper.readValue(responseBody, TradeHistoryResponseDto.class);
		InnerRow[] row = tradeHistoryResponseDto.getTbLnOpendataRtmsV().getRow();

		List<TradeHistoryVO> tradeHistoryVOList = new ArrayList<>();
		for (InnerRow innerRow : row) {
			TradeHistoryVO tradeHistoryVO = TradeHistoryVO.createFromJson(innerRow);
			tradeHistoryVOList.add(tradeHistoryVO);
		}

		tradeHistoryRepository.saveAll(tradeHistoryVOList);

		log.info("[{}] 가져온 데이터 수 = {}", trxNo, tradeHistoryVOList.size());
		log.info("[{}] 가져온 데이터 = {}", trxNo, tradeHistoryVOList);

		LocalDateTime endtLocalDateTime = LocalDateTime.now();
		String endTime = formatter.format(endtLocalDateTime);
		long startTimeInteger = Long.parseLong(startTime);
		long endTimeTimeInteger = Long.parseLong(endTime);
		long trxTime = endTimeTimeInteger - startTimeInteger;
		log.info("[{}] 소요시간: {}", trxNo, trxTime);
		log.info("[{}] ========== getTradeHistory END ==========", trxNo);
	}
}