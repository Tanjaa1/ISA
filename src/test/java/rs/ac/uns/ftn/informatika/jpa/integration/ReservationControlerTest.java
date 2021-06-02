package rs.ac.uns.ftn.informatika.jpa.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.util.TestUtil;

@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReservationControlerTest {
    private static final String URL_PREFIX = "/reservation";

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
            private MockMvc mockMvc;

            @Autowired
            private WebApplicationContext webApplicationContext;
            
            @Before
            public void setup() {
                this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
            }

            @Test
            @WithMockUser(roles = "PHARMACIST")
            public void testGetReservationById() throws Exception {

                ReservationDTO r=new ReservationDTO();
                r.setId(1L);
                r.setExpirationDate(new Date(2021,8,12));
                r.setIsReceived(false);
                r.setIsCanceled(false);

		        String json = TestUtil.json(r);
                mockMvc.perform(get(URL_PREFIX + "/getReservationById/"+1L+"/"+1L))
                .andExpect(status().isOk());
            }

            @Test
            @WithMockUser(roles = "PHARMACIST")
            public void testUpdateReservation() throws Exception {

                ReservationDTO r=new ReservationDTO();
                r.setId(100L);
                r.setExpirationDate(new Date(2021,8,12));
                r.setIsReceived(false);
                r.setIsCanceled(false);

		        String json = TestUtil.json(r);
                mockMvc.perform(put(URL_PREFIX + "/update").contentType(contentType).content(json))
                .andExpect(status().isOk());
            }
}
