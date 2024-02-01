package sqlfrontend.EmployeeController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

}
