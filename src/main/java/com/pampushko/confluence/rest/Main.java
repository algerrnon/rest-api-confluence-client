package com.pampushko.confluence.rest;

import com.pampushko.confluence.models.label.Label;
import com.pampushko.confluence.settings.SettingsManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Базовый класс для запуска клиента
 * <br>
 */
@Slf4j
public class Main
{
	public static final String url = "";
	private static final String username = "";
	private static final String password = "";
	
	public static void main(String[] args) throws IOException
	{
		
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		Confluence confluence = Confluence.newBuilder().baseUrl(settings.getProperty("baseUrl")).username(settings.getProperty("username")).password(settings.getProperty("password")).build();
		
		//идентификатор страницы на которую добавляется вложение
		final String contentId = "5210113";
		
		//создаём список из меток
		List<Label> labels = new ArrayList<>();
		final String labelName1 = "test1";
		final String labelName2 = "test\\2"; //а вот эта метка не удаляется?
		
		final String labelName3 = "test/3";
		
		System.out.println(labelName2);
		
		//выполняем запрос и печатаем результат
		Object response = confluence.deleteLabels(contentId, labelName3);
		System.out.println(response);
	}
}
