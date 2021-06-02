package rs.ac.uns.ftn.informatika.jpa.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IReservationRepository;
import rs.ac.uns.ftn.informatika.jpa.service.ResrvationService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ReservationServiceTest {
    @MockBean
    private IReservationRepository reservationRpository;

    @Autowired
    private ResrvationService reservationService;

    @Test
    public void testFindReservationById()
    {
        Reservation reservation=new Reservation();
        reservation.setId(123L);
        reservation.setIsCanceled(false);
        reservation.setIsReceived(false);
        reservation.setExpirationDate(java.util.Date.from(LocalDate.now().plusDays(1).atStartOfDay()
        .atZone(ZoneId.systemDefault())
        .toInstant()));
        
        when(reservationRpository.getReservationById(123L, 1L)).thenReturn(reservation); 
        ReservationDTO reservationDTO=reservationService.getReservationById(123L,1L);
        assertNotNull(reservationDTO);
    }

    @Test
    public void testNotFindReservationByIdBecauseExpirationDatePassed()
    {
        Reservation reservation=new Reservation();
        reservation.setId(123L);
        reservation.setIsCanceled(false);
        reservation.setIsReceived(false);
        reservation.setExpirationDate(java.util.Date.from(LocalDate.now().minusDays(1).atStartOfDay()
        .atZone(ZoneId.systemDefault())
        .toInstant()));
        
        when(reservationRpository.getReservationById(123L, 1L)).thenReturn(reservation); 
        ReservationDTO reservationDTO=reservationService.getReservationById(123L,1L);
        assertNull(reservationDTO);
    }

    @Test
    public void testNotFindReservationByIdBecauseCanceled()
    {
        Reservation reservation=new Reservation();
        reservation.setId(123L);
        reservation.setIsCanceled(true);
        reservation.setIsReceived(false);
        reservation.setExpirationDate(java.util.Date.from(LocalDate.now().plusDays(5).atStartOfDay()
        .atZone(ZoneId.systemDefault())
        .toInstant()));
        
        when(reservationRpository.getReservationById(123L, 1L)).thenReturn(reservation); 
        ReservationDTO reservationDTO=reservationService.getReservationById(123L,1L);
        assertNull(reservationDTO);
    }

    @Test
    public void testNotFindReservationByIdBecauseIsReceived()
    {
        Reservation reservation=new Reservation();
        reservation.setId(123L);
        reservation.setIsCanceled(false);
        reservation.setIsReceived(true);
        reservation.setExpirationDate(java.util.Date.from(LocalDate.now().plusDays(5).atStartOfDay()
        .atZone(ZoneId.systemDefault())
        .toInstant()));
        
        when(reservationRpository.getReservationById(123L, 1L)).thenReturn(reservation); 
        ReservationDTO reservationDTO=reservationService.getReservationById(123L,1L);
        assertNull(reservationDTO);
    }
}
