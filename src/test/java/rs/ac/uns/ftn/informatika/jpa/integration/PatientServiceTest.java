package rs.ac.uns.ftn.informatika.jpa.integration;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PatientServiceTest {
    private static final String URL_PREFIX = "/patient";

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
            public void saveDrugAll() throws Exception {
                String drugAllergies="penicilin,cefaleksin";
                mockMvc.perform(get(URL_PREFIX + "/savePatientDrugAllergies/" +drugAllergies ).contentType(contentType))
                .andExpect(status().isOk());
            }

            /*public ActionOrPromotionsDTO cancelActionOrPromotion(String id, String idAction) throws Exception {
		
            	Long PatientId=Integer.toUnsignedLong(Integer.valueOf(id));	
		Long actionOrPromotionId=Integer.toUnsignedLong(Integer.valueOf(idAction));

		Patient patientToUpdate=patientRepository.findById(PatientId).get();
		ActionOrPromotion toCancel=actionOrPromotionRepository.getOne(actionOrPromotionId);
		Set<ActionOrPromotion> newSetA=patientToUpdate.getActionOrPromotion();
		newSetA.remove(toCancel);
		patientToUpdate.setActionOrPromotion(newSetA);
		update(patientToUpdate);
		emailSenderActionsOrPromotionsCancel(patientToUpdate,toCancel);

		return new ActionOrPromotionsDTO(toCancel); */
        @Test
        @WithMockUser(roles = "PATIENT")
        public void cancelActionOrPromotion() throws Exception {
           String actionId="222";
           String patirenId="88";
            mockMvc.perform(get(URL_PREFIX + "/cancelActionOrPromotion/" + patirenId + "/" + actionId  ).contentType(contentType))
            .andExpect(status().isOk());
        }
}
