package rs.ac.uns.ftn.informatika.jpa.integration;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurerAdapter;
import org.springframework.web.context.WebApplicationContext;

import io.jsonwebtoken.Jwt;
import rs.ac.uns.ftn.informatika.jpa.controller.AuthenticationController;
import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.util.TestUtil;

@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExaminationControlerTest {
    private static final String URL_PREFIX = "/examination";

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
            @WithMockUser(roles = "DERMATOLOGIST")
            public void testDontUpdateExamination() throws Exception {

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
            @WithMockUser(roles = "DERMATOLOGIST")
            public void testGetFreeExaminationByDermatologist() throws Exception {
                List<ExaminationDTO> examinations=new ArrayList<ExaminationDTO>();
                ExaminationDTO e=new ExaminationDTO();
                e.setId(100L);
                examinations.add(e);
		        String json = TestUtil.json(examinations);
                mockMvc.perform(get(URL_PREFIX + "/getFreeExaminationByDermatologist/"+1L))
                .andExpect(status().isOk());
            }
}
