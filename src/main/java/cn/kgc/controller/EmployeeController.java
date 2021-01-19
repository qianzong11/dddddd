package cn.kgc.controller;

import cn.kgc.entity.Employee;
import cn.kgc.service.EmployeeService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2021-01-13 09:55:22
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employee selectOne(Integer id) {
        return this.employeeService.queryById(id);
    }

    /**
     * 查询所有员工
     * @param model
     * @return
     */
    @RequestMapping("queryAllEmp")
    public String queryAllEmp(Model model){
        List<Employee> employeeList=employeeService.findAllEmp();
        model.addAttribute("emplist",employeeList);
        return "emplist";
    }
    @RequestMapping("delEmp")
    @ResponseBody
    public JSON delEmp(Integer empId){
        System.out.println("员工id:"+empId);
        boolean b=employeeService.deleteById(empId);
        Map<String,Boolean> resultMap=new HashMap<>();
        resultMap.put("result",b);
        return (JSON)JSON.toJSON(resultMap);
    }
    @RequestMapping("addEmp")
    public String addEmp(Employee employee){
        Employee emp = employeeService.insert(employee);
        if (emp!=null){
            return "redirect:/employee/queryAllEmp";
        }else {
            return "forward:addemp.jsp";
        }


    }
    @RequestMapping("updt")
    public String updt(Integer id,Model model){
        Employee queryById = employeeService.queryById(id);
        model.addAttribute("queryById",queryById);
        return "updt";

    }
    @RequestMapping("updtEmp")
    public String updtEmp(Employee employee ){
        System.out.println(employee);
        Employee emp = employeeService.update(employee);
        if (emp!=null){
            System.out.println("1");
        }else {
            System.out.println("0");
        }
            return "redirect:/employee/queryAllEmp";
    }



}