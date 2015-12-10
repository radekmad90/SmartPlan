package pl.pcz.wimii.zpi.smartplan.parser;

import java.util.Calendar;

public class ParserUtils {
	public static Calendar getDateFromString(String str) {
		Calendar date = Calendar.getInstance();
		String[] dateElements = str.split("-");
		date.set(Calendar.YEAR, Integer.parseInt(dateElements[0].replace(" Data publikacji: ", "").trim()));
		date.set(Calendar.MONTH, Integer.parseInt(dateElements[1].trim()) -1);
		date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateElements[2].trim()));
		return date;
	}
}
