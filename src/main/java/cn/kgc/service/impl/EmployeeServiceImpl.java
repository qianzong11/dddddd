package cn.kgc.service.impl;

import cn.kgc.entity.Employee;
import cn.kgc.dao.EmployeeDao;
import cn.kgc.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author makejava
 * @since 2021-01-13 09:55:22
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param empid 主键
     * @return 实例对象
     */
    @Override
    public Employee queryById(Integer empid) {
        return this.employeeDao.queryById(empid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAllByLimit(int offset, int limit) {
        return this.employeeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee insert(Employee employee) {
        this.employeeDao.insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee update(Employee employee) {
        this.employeeDao.update(employee);
        return this.queryById(employee.getEmpid());
    }

    /**
     * 通过主键删除数据
     *
     * @param empid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer empid) {
        return this.employeeDao.deleteById(empid) > 0;
    }

    @Override
    public List<Employee> findAllEmp() {
        return this.employeeDao.getAllEmp();
    }
}