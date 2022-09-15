package com.tinkoff.translater.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationDetails {
	Long id;
	String sourceText;
	String translatedText;
	String toLanguage;
	String ip;
	Date requestDate;
}
