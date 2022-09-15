package com.tinkoff.translater.service;

import com.tinkoff.translater.dao.TranslationDAO;
import com.tinkoff.translater.entity.TranslationDetails;
import com.tinkoff.translater.helper.DateHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class TranslatorService {

	private final TranslationDAO translationDAO;
	private final TranslatorAPIService translatorAPIService;

	public String translateText(String toLanguage, String text, String ip) {
		Date requestDate = DateHelper.getCurrentDate();
		String translatedText = translatorAPIService.translateText(text, toLanguage);

		translationDAO.save(new TranslationDetails(null, text, translatedText, toLanguage, ip, requestDate));

		return translatedText;
	}
}
