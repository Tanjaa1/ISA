package rs.ac.uns.ftn.informatika.jpa.unit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IUserRepository;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserServiceTest {
    @MockBean
    private IUserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
	public void testisUsernameValidTrue() {
        List<User> users=new ArrayList<>();
        String usernameToTest="balsa";

       User user1=new User(122L,"balsa@gmail.com","123","Balsa","Balasevic","address","Beograd","Srbija","061431467","desc",true,true,"balsa");
       User user2=new User(123L,"nikola@gmail.com","123","Nikola","Nikola","address1","Novi Sad","Srbija","5555552","desc1",true,false,"nikola");
        users.add(user1);
        users.add(user2);
        when(userRepository.findAll()).thenReturn(users);
        Boolean result=userService.isUsernameValid(usernameToTest);

        assertFalse(result);
    }
    @Test
    public void testisUsernameValidFalse() 
    {   
        List<User> users=new ArrayList<>();
        String usernameToTest="balsa123";
        User user1=new User(122L,"balsa@gmail.com","123","Balsa","Balasevic","address","Beograd","Srbija","061431467","desc",true,true,"balsa");
        User user2=new User(123L,"nikola@gmail.com","123","Nikola","Nikola","address1","Novi Sad","Srbija","5555552","desc1",true,false,"nikola");
         users.add(user1);
         users.add(user2);
         when(userRepository.findAll()).thenReturn(users);
       Boolean result=userService.isUsernameValid(usernameToTest);
        assertTrue(result);
    }
}
