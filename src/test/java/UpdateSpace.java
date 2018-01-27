import com.pampushko.confluence.models.Space;
import com.pampushko.confluence.models.SpaceResultList;
import com.pampushko.confluence.rest.ConfluenceClient;
import com.pampushko.confluence.settings.SettingsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
public class UpdateSpace
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static void main(String[] args) throws IOException
	{
		//читаем настройки приложения
		Properties settings = SettingsManager.getValues();
		
		//вызываем билдер и создаем клиент
		ConfluenceClient confluence = ConfluenceClient.newBuilder()
				.baseUrl(settings.getProperty("baseUrl"))
				.username(settings.getProperty("username"))
				.password(settings.getProperty("password"))
				.build();
		
		Space resultSpace = null;
		
		SpaceResultList spaces = confluence.getSpaces();
		for (Space space : spaces.getSpaces())
		{
			System.out.println(space);
		}
		Map<String, String> params = new HashMap<String, String>()
		{
			{
				//получаем значение параметра description
				//который по умолчанию не присутствует в наборе полей
				//а размещён в разделе _expand
				//и также указываем, что хотим заэкспандить раздел plain из description
				//так как description это тоже объект и чтобы получить в этом объекте поле plain,
				//это поле также необходимо развернуть.
				put("expand", "description");
				put("expand", "description.plain");
			}
		};
		
		Space space = confluence.getSpaceByKey("KARMA", params);
		//обновляем описание области
		space.setDescription("Hello! I love you, i am OK");
		confluence.updateSpace(space, "KARMA");
		
		System.out.println(space);
	}
}

