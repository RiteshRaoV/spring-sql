package sqlfrontend.apiController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import sqlfrontend.apiClasses.Dog;
import sqlfrontend.apiClasses.User;

@Controller
public class apiController {

    @GetMapping("/extractEmails")
    @ResponseBody
    public List<String> extractEmails() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/users";

        try {
            // Make HTTP GET request and parse JSON response into an array of users
            User[] users = restTemplate.getForObject(url, User[].class);

            // Extract emails from each user
            List<String> emails = new ArrayList<String>();
            for (User user : users) {
                emails.add(user.getEmail());
            }

            return emails;
        } catch (Exception e) {
            return new ArrayList<>(Arrays.asList("Error fetching users: " + e.getMessage()));
        }
    }

    @GetMapping("/user")
    public String getUser(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://jsonplaceholder.typicode.com/users";
        User[] users = restTemplate.getForObject(apiUrl, User[].class);
        model.addAttribute("ApiUser", users);
        return "api/user";
    }

    @GetMapping("/GenerateDog")
    public String dogGenerateMethod(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://dog.ceo/api/breeds/image/random";
        Dog dog = restTemplate.getForObject(apiUrl, Dog.class);
        model.addAttribute("DogImage", dog);
        return "api/Dog";
    }
}
