package validadate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe de utilitário para validação de intervalo de datas.
 * 
 * @author Walberg Santos
 * @version 1.0
 * 
 * @see ValidateDateTest
 */

public class ValidateDate {
	
	 /**
	 *
	 * @param startDate - Data inicial.
	 * @param endDate - Data final.
	 * @return {@code true} se as datas forem válidas, {@code false} caso contrário.
	 * @throws IllegalArgumentException - Se qualquer uma das datas for nula,
	 *                                    se a data inicial for posterior à data final,
	 *                                    ou se o intervalo entre as datas for superior a 30 dias.
	 * @see LocalDate
	 */

	public static Boolean validate(LocalDate startDate, LocalDate endDate) {

		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("A data inital e a data final precisam ser informadas");
		}
		
		if (startDate.isAfter(endDate)) {
			throw new IllegalArgumentException("A data inital não pode ser posterior à data final");	
		}
		
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);	
		if (daysBetween > 30) {
			throw new IllegalArgumentException("O intervalo entre as datas não pode ser superior a 30 dias");
		}

		return true;
	}
}