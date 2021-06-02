package rs.ac.uns.ftn.informatika.jpa.integration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import rs.ac.uns.ftn.informatika.jpa.dto.CouncelingDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.util.TestUtil;

@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CounselingControlerTest {
    private static final String URL_PREFIX = "/counseling";

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
            public void testDontUpdateCounsleing() throws Exception {

                Patient p=new Patient();
                p.setId(88L);
                p.setPoints(12);
                Examination e=new Examination();
                e.setId(115L);
                e.setPatient(p);
		        String json = TestUtil.json(e);
                
                mockMvc.perform(put(URL_PREFIX + "/finish").contentType(contentType).content(json))
                .andExpect(status().isBadRequest());
            }

            @Test
            @WithMockUser(roles = "PHARMACIST")   
            @Transactional
            @Rollback(true)
            public void testGetFreeCounselingnByPharmacist() throws Exception {
                mockMvc.perform(get(URL_PREFIX + "/getFreeCounselingByPharmacist/"+1L))
                .andExpect(status().isOk());
            }
}