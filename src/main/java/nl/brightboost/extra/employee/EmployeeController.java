package nl.brightboost.extra.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="employee", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @RequestMapping(value="employee/{id}", method = RequestMethod.GET)
    public Employee getEmployees(@PathVariable long id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value="employee", method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

}
