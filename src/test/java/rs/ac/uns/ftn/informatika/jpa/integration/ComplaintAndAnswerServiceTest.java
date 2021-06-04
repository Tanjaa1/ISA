package rs.ac.uns.ftn.informatika.jpa.integration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.ComplaintAnswer;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Penaltys;
import rs.ac.uns.ftn.informatika.jpa.util.TestUtil;
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ComplaintAndAnswerServiceTest {
    private static final String URL_PREFIX = "/complaintAndAnswer";

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
            @WithMockUser(roles = "ADMIN")
            public void testAnswerCompliant() throws Exception {
                String da1="amooksicilin";
                List<String>drugList=new ArrayList<>();
                drugList.add(da1);
                Penaltys pe=new Penaltys();
                Set<Penaltys> ps=new HashSet<>();
                ps.add(pe);
                Patient patient=new Patient(88L,"email","password","Nika","Ninkovic","address","city",
                "country","29652152","desc",true,true,"username",drugList,25,ps,LoyaltyCategories.Gold, new HashSet<Complaint>(),
                new HashSet<Counseling>(),new HashSet<EPrescription>(),new HashSet<>(),new HashSet<>());
                Complaint complaint=new Complaint(111L, "neljubazn", "Joavn Jovovic", patient, false);
                ComplaintAnswer cAa=new ComplaintAnswer(complaint, "text");
              
		        String json = TestUtil.json(cAa);
                mockMvc.perform(post(URL_PREFIX + "/saveComplaintAndAnswer").contentType(contentType).content(json))
                .andExpect(status().isCreated());
            }
}
