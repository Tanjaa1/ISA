package rs.ac.uns.ftn.informatika.jpa.integration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import rs.ac.uns.ftn.informatika.jpa.enums.EPrescriptionStatus;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.util.TestUtil;
import rs.ac.uns.ftn.informatika.jpa.util.VacationInterval;

@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EPrescriptionControlerTest {
    private static final String URL_PREFIX = "/eprescription";

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
            @WithMockUser(roles = {"PHARMACIST","DERMATOLOGIST"})
            public void testAaddEPresrciption() throws Exception {

                Medicine m=new Medicine();
                m.setId(111L);
                MedicinePriceAndQuantity mpaq=new MedicinePriceAndQuantity();
                mpaq.setId(32L);
                mpaq.setMedicine(m);
                Pharmacy p=new Pharmacy();
                p.setId(111L);
                EPrescription e=new EPrescription();
                e.setIssuingDate(new Date(2021, 12, 11));
                e.setMedicine(mpaq);
                e.setPharmacy(p);
                e.setStatus(EPrescriptionStatus.New);
                e.setTherapyDuration(5);
		        String json = TestUtil.json(e);

                mockMvc.perform(post(URL_PREFIX + "/add/"+88L).contentType(contentType).content(json))
                .andExpect(status().isOk());
            }

            @Test
            @WithMockUser(roles = {"PHARMACIST","DERMATOLOGIST"})
            public void testFindMedicines() throws Exception {

                Medicine m=new Medicine();
                m.setId(111L);
                MedicinePriceAndQuantity mpaq=new MedicinePriceAndQuantity();
                mpaq.setId(32L);
                mpaq.setMedicine(m);
                Pharmacy p=new Pharmacy();
                p.setId(111L);
                EPrescription e=new EPrescription();
                e.setIssuingDate(new Date(2021, 12, 11));
                e.setMedicine(mpaq);
                e.setPharmacy(p);
                e.setStatus(EPrescriptionStatus.New);
                e.setTherapyDuration(5);
		        String json = TestUtil.json(e);

                mockMvc.perform(get(URL_PREFIX + "/findMedicines/"+111L))
                .andExpect(status().isOk());
            }

}
