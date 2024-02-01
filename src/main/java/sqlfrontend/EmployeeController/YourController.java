package sqlfrontend.EmployeeController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import sqlfrontend.Employee.Employee;
import sqlfrontend.EmployeeService.EmployeeService;

// YourController.java
@Controller
public class YourController {

    @Autowired
    private EmployeeService yourService;

    @GetMapping("/add")
    public String showAddForm() {
        // model.addAttribute("employee", new Employee());
        return "add";
    }
    @GetMapping("/api")
    public String apiTesting() {
        return "apitesting";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute Employee employee) {
        yourService.saveEmployee(employee);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = yourService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        yourService.updateEmployee(employee);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<Employee> employee = yourService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute Employee employee) {
        yourService.deleteEmployee(employee.getId());
        return "redirect:/list";
    }

    @GetMapping("/extractEmails")
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
        String apiUrl="https://jsonplaceholder.typicode.com/users";
        User[] users = restTemplate.getForObject(apiUrl, User[].class);
        model.addAttribute("ApiUser", users);
        return "user";
    }
    @GetMapping("/GenerateDog")
    public String dogGenerateMethod(Model model){
        RestTemplate restTemplate=new RestTemplate();
        String apiUrl="https://dog.ceo/api/breeds/image/random";
        Dog dog=restTemplate.getForObject(apiUrl, Dog.class);
        model.addAttribute("DogImage", dog);
        return "Dog";
    }
   
}

