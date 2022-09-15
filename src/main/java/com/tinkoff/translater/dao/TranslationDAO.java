package com.tinkoff.translater.dao;

import com.tinkoff.translater.entity.TranslationDetails;
import org.springframework.stereotype.Repository;


public interface TranslationDAO {
	public Long save(TranslationDetails translationDetails);
}
