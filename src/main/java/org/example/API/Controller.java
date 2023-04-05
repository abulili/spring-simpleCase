package org.example.API;

import org.example.Model.EandL;
import org.example.Model.Employee;
import org.example.Model.User;
import org.example.Service.EmployDBService;
import org.example.Service.LocationDBService;
import org.example.Service.UserDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@org.springframework.stereotype.Controller
@RequestMapping("API/work1")
public class Controller {
    private UserDBService userDBService;
    private EmployDBService employDBService;
    private LocationDBService locationDBService;
    @Autowired
    public Controller(UserDBService userDBService, EmployDBService employDBService, LocationDBService locationDBService) {
        this.userDBService = userDBService;
        this.employDBService = employDBService;
        this.locationDBService = locationDBService;
    }
//    user
    //login
    @GetMapping("loginCheck/{UserName1}/{Password1}")
    @ResponseBody
    public User loginCheck(@PathVariable("UserName1") String UserName1, @PathVariable("Password1") String Password1) {
        return userDBService.selectUser(UserName1,Password1);
    }
    //register
    @GetMapping("registerCheck/{UserName2}")
    @ResponseBody
    public User registerCheck(@PathVariable("UserName2") String UserName2) {
        return userDBService.selectUserName(UserName2);
    }
    @GetMapping("insertUser/{UserName2}/{Password2}")
    @ResponseBody
    public String insertUser(@PathVariable("UserName2") String UserName2, @PathVariable("Password2") String Password2) {
        if(userDBService.insertUser(UserName2, Password2)) {
            return "login";
        }
        return "register";
    }
    //manage
    @GetMapping("Manage/deleteEmployeeById/{employeeId}")
    public String deleteEmployeeById(@PathVariable("employeeId") String employeeId, RedirectAttributes ra) {
        employDBService.deleteEmployeeById(employeeId);
        ra.addFlashAttribute("message", "have been delete");
        return "redirect:/API/work1/Manage";
    }
    //edit
    @GetMapping("edit/addEmployee/{employeeId}/{employeeName}/{gender}/{age}/{baseSalary}/{locationId}")
    public void addEmployee(@PathVariable("employeeId") String employeeId, @PathVariable("employeeName") String employeeName,@PathVariable("gender") String gender,@PathVariable("age") String age,@PathVariable("baseSalary") String baseSalary, @PathVariable("locationId") String locationId) {
        if(employDBService.selectEmployeeById(employeeId).size() != 0)
            employDBService.updateEmployee(employeeId,employeeName, gender,age,baseSalary,locationId);
        else
        employDBService.inserEmployee(employeeId,employeeName, gender,age,baseSalary,locationId);
    }

    //    页面
    @GetMapping("login")
    public String login() {
        return "login";
    }
    @GetMapping("register")
    public String register() {
        return "register";
    }
    @GetMapping("index")
    public String index() {
        return "index";
    }
    @GetMapping("Manage")
    public String users(Model model) {
        List<Employee> EmployeeList = employDBService.selectAllEmployee();
        model.addAttribute("listEmployee",EmployeeList);
        return "Manage";
    }
    @GetMapping("edit/sure/{employeeId}")
    public String edit(@PathVariable("employeeId") String employeeId, Model model) {
        List<Employee> employees = employDBService.selectEmployeeById(employeeId);
        model.addAttribute("Employee", employees);
        return "edit";
    }
    @GetMapping("baiduMap/serach/{locationId}/{employeeId}")
    public String baiduMapSerach(@PathVariable("locationId")String locationId, @PathVariable("employeeId")String employeeId,Model model) {
        List<EandL> employees = locationDBService.selectLocationAndEmployee(locationId, employeeId);
        model.addAttribute("EandL", employees);
        return "baiduMap";
    }
}
