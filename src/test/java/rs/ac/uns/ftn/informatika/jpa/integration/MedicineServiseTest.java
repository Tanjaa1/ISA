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
import java.util.Date;import org.springframework.web.context.WebApplicationContext;
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MedicineServiseTest {
    private static final String URL_PREFIX = "/medicine";

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
            @WithMockUser(roles = "PATIENT")
            public void getPharmacyForAvaliableMedicineAndQuantityTest() throws Exception {
                String medicineName="Brufen";
                Integer quantity=10000;
              
                mockMvc.perform(get(URL_PREFIX + "/getPharmacyForAvaliableMedicineAndQuantity/" +quantity +"/"+medicineName ).contentType(contentType))
                .andExpect(status().isBadRequest());
            }
}
