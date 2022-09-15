package com.tinkoff.translater.service;

import com.tinkoff.translater.config.YandexAPIConfig;
import com.tinkoff.translater.dto.request.YandexTranslationRequestDTO;
import com.tinkoff.translater.dto.response.YandexResultTranslationResponseDTO;
import com.tinkoff.translater.dto.response.YandexTextTranslationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@RequiredArgsConstructor
public class TranslatorAPIService {
	private final YandexAPIConfig yandexAPIConfig;
	public String translateText(String text, String toLanguage) {
		YandexTranslationRequestDTO requestDTO = new YandexTranslationRequestDTO(yandexAPIConfig.getFolderId(),
				List.of(text.split(" ")), toLanguage);
		WebClient client = WebClient.create(yandexAPIConfig.getApiTranslationUrl());

		YandexResultTranslationResponseDTO responseDTO = client.post()
				.header(AUTHORIZATION, "Bearer " + yandexAPIConfig.getToken())
				.accept(APPLICATION_JSON)
				.body(BodyInserters.fromValue(requestDTO))
				.retrieve()
				.bodyToMono(YandexResultTranslationResponseDTO.class)
				.block();

		return responseDTO.getTranslations().stream()
				.map(YandexTextTranslationDTO::getText)
				.reduce((x, y) -> x + " " + y).get();

	}
}
