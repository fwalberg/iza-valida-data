package validadate;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ValidateDateTest {

    @Test
    public void testValidateDateSuccess() {
        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 30);
        try {
            Boolean result = ValidateDate.validate(startDate, endDate);
            assertTrue(result);
        } catch (IllegalArgumentException e) {
            fail("Nenhuma exceção espera aqui: " + e.getMessage());
        }
    }
    
    @Test
    public void testDateIntervalEquals30Days() {
        LocalDate startDate = LocalDate.of(2024, 7, 1);
        LocalDate endDate = startDate.plusDays(30);
        try {
            Boolean result = ValidateDate.validate(startDate, endDate);
            assertTrue(result);
        } catch (IllegalArgumentException e) {
            fail("Nenhuma exceção espera aqui: " + e.getMessage());
        }
    }

    @Test
    public void testStartDateNull() {
        LocalDate startDate = null;
        LocalDate endDate = LocalDate.of(2024, 9, 15);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateDate.validate(startDate, endDate);
        });
        assertEquals("A data inital e a data final precisam ser informadas", exception.getMessage());
    }

    @Test
    public void testEndDateNull() {
        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateDate.validate(startDate, endDate);
        });
        assertEquals("A data inital e a data final precisam ser informadas", exception.getMessage());
    }

    @Test
    public void testStartDateAfterEndDate() {
        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 7, 15);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateDate.validate(startDate, endDate);
        });
        assertEquals("A data inital não pode ser posterior à data final", exception.getMessage());
    }

    @Test
    public void testDateIntervalMoreThan30Days() {
        LocalDate startDate = LocalDate.of(2024, 7, 1);
        LocalDate endDate = startDate.plusDays(31);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateDate.validate(startDate, endDate);
        });
        assertEquals("O intervalo entre as datas não pode ser superior a 30 dias", exception.getMessage());
    }
}

