package com.tinkoff.translater.service;

import com.tinkoff.translater.config.YandexAPIConfig;
import com.tinkoff.translater.dto.request.YandexGettingIAMTokenRequestDTO;
import com.tinkoff.translater.dto.response.YandexIAMTokenResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@RequiredArgsConstructor
public class YandexAPIService {
	private final YandexAPIConfig yandexAPIConfig;

	/**
	 * Requests an IAM token
	 * @return IAM token
	 */
	public String getYandexIAMToken() {
		YandexGettingIAMTokenRequestDTO requestDTO = new YandexGettingIAMTokenRequestDTO(yandexAPIConfig.getOAuthToken());

		WebClient client = WebClient.create(yandexAPIConfig.getApiGettingTokenUrl());
		YandexIAMTokenResponseDTO responseDTO = client.post()
				.accept(APPLICATION_JSON)
				.body(BodyInserters.fromValue(requestDTO))
				.retrieve()
				.bodyToMono(YandexIAMTokenResponseDTO.class)
				.block();

		return responseDTO.getIamToken();
	}
}
