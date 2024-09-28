package com.gwnu.mybatis.chap03.sub02.using_xml;

import com.gwnu.mybatis.chap03.sub01.using_interface.model.service.EmployeeService;
import com.gwnu.mybatis.chap03.sub02.using_xml.model.Service.DepartmentService;

public class Application {
    private DepartmentService departmentService;
    private EmployeeService employeeService;

    public Application() {
        departmentService = new DepartmentService();
        employeeService = new EmployeeService();
    }
    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
    }
}
