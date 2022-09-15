package com.tinkoff.translater.controller;

import com.tinkoff.translater.dto.request.TranslateTextRequestDTO;
import com.tinkoff.translater.dto.response.TextTranslationResponseDTO;
import com.tinkoff.translater.service.TranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/translator")
@RequiredArgsConstructor
public class TranslationController {
	private final TranslatorService translatorService;

	@PostMapping("/translate")
	public ResponseEntity<TextTranslationResponseDTO> translateWords(@RequestBody TranslateTextRequestDTO requestDTO,
																	 HttpServletRequest request) {
		String translatedText = translatorService.translateText(requestDTO.getToLanguage(),
				requestDTO.getText(), request.getRemoteAddr());
		TextTranslationResponseDTO responseDTO = new TextTranslationResponseDTO(translatedText);
		return ResponseEntity.ok().body(responseDTO);
	}
}
