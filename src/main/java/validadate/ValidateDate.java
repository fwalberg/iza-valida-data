package validadate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe utilitaria para validação de intervalo de datas.
 * 
 * @author Walberg Santos
 * @version 1.0
 * 
 * @see src/test/java/ValidateDateTest
 */

public class ValidateDate {
	
	 /**
	 *
	 * @param startDate - data inicial.
	 * @param endDate - data final.
	 * @return {@code true} se as datas forem válidas, {@code false} caso contrário.
	 * @throws IllegalArgumentException se qualquer das datas for nula,
	 *                                  data inicial for posterior à data final ou
	 *                                  intervalo entre datas superior a 30 dias.
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