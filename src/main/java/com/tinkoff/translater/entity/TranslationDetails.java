package com.tinkoff.translater.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationDetails {
	private Long id;
	private String sourceText;
	private String translatedText;
	private String toLanguage;
	private String ip;
	private Date requestDate;
}
