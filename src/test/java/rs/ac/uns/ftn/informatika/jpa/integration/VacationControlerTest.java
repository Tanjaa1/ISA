package rs.ac.uns.ftn.informatika.jpa.integration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import rs.ac.uns.ftn.informatika.jpa.util.TestUtil;
import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VacationControlerTest {
    private static final String URL_PREFIX = "/vacation";

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
            public void testAaddPharmacistVacation() throws Exception {

                VacationInterval v=new VacationInterval();
                v.setId(1L);
                v.setApproved(false);
                v.setPharmacyId(111L);
                v.setDateStart(new Date(2021, 12, 12));
                v.setDateEnd(new Date(2021, 12, 12));
		        String json = TestUtil.json(v);
                mockMvc.perform(post(URL_PREFIX + "/addPharmacistVacation/"+444L).contentType(contentType).content(json))
                .andExpect(status().isOk());
            }

            @Test
            @WithMockUser(roles = "DERMATOLOGIST")
            public void testAadDermatologistVacation() throws Exception {

                VacationInterval v=new VacationInterval();
                v.setId(1L);
                v.setApproved(false);
                v.setPharmacyId(111L);
                v.setDateStart(new Date(2021, 12, 12));
                v.setDateEnd(new Date(2021, 12, 12));
		        String json = TestUtil.json(v);
                mockMvc.perform(post(URL_PREFIX + "/addDermatologistVacation/"+66L).contentType(contentType).content(json))
                .andExpect(status().isOk());
            }
}
