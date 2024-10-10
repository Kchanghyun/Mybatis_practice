package com.gwnu.mybatis.chap03.sub02.using_xml;

import com.gwnu.mybatis.chap03.sub02.using_xml.model.Service.DepartmentService;
import com.gwnu.mybatis.chap03.sub02.using_xml.model.Service.EmployeeService;
import com.gwnu.mybatis.chap03.sub02.using_xml.model.dto.DepartmentDto;
import com.gwnu.mybatis.chap03.sub02.using_xml.model.dto.EmployeeDto;

import java.util.List;
import java.util.Scanner;

public class Application {
    private DepartmentService departmentService;
    private EmployeeService employeeService;
    private static Scanner sc = new Scanner(System.in);

    public Application() {
        departmentService = new DepartmentService();
        employeeService = new EmployeeService();
    }
    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        System.out.println("안녕하세요. 우리 한 번 데이터베이스를 통해 값을 수정해볼까요?");
        System.out.println("그럼 뭐부터 해볼까요?");
        while(true) {
            System.out.println("--------menu--------");
            System.out.println("|\t1. 부서 조회\t\t|");
            System.out.println("|\t2. 부서 추가\t\t|");
            System.out.println("|\t3. 부서 삭제\t\t|");
            System.out.println("|\t4. 부서 수정\t\t|");
            System.out.println("|\t5. 직원 조회\t\t|");
            System.out.println("|\t6. 직원 추가\t\t|");
            System.out.println("|\t7. 직원 삭제\t\t|");
            System.out.println("|\t8. 직원 수정\t\t|");
            System.out.println("|\t0. 나가기   \t\t|");
            System.out.println("--------------------");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    selectDepartment();
                    break;
                case 2:
                    insertDepartment();
                    break;
                case 3:
                    deleteDepartment();
                    break;
                case 4:
                    updateDepartment();
                    break;
                case 5:
                    selectEmployee();
                    break;
                case 6:
                    insertEmployee();
                    break;
                case 7:
                    deleteEmployee();
                    break;
                case 8:
                    updateEmployee();
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    public void selectDepartment() {
        List<DepartmentDto> dtos = departmentService.selectAllDepartments();

        dtos.forEach(System.out::println);
    }

    public void insertDepartment() {
        System.out.println("새로운 부서명을 입력해주세요.");
        String name = sc.nextLine();

        DepartmentDto tmp = new DepartmentDto();
        tmp.setDepartmentName(name);

        int result = departmentService.insertNewDepartment(tmp);

        if (result > 0) System.out.println(name + " 부서가 생성되었습니다.");
        else System.out.println("부서 생성에 실패하였습니다.");
    }

    public void deleteDepartment() {
        System.out.println("삭제할 부서의 ID를 입력해주세요.");
        Long ID = sc.nextLong();
        sc.nextLine();

        DepartmentDto tmp = new DepartmentDto();
        tmp.setDepartmentId(ID);

        int result = departmentService.deleteDepartment(tmp);

        if (result > 0) System.out.println("부서 삭제 성공");
        else System.out.println("부서 삭제 실패");
    }

    public void updateDepartment() {
        System.out.println("수정하고 싶은 부서의 ID를 입력하세요.");
        Long ID = sc.nextLong();
        sc.nextLine();

        System.out.println("수정하고 싶은 부서명을 입력하세요.");
        String name = sc.nextLine();

        DepartmentDto tmp = new DepartmentDto();
        tmp.setDepartmentId(ID);
        tmp.setDepartmentName(name);

        int result = departmentService.updateDepartment(tmp);

        if (result > 0) System.out.println("수정 성공");
        else System.out.println("수정 실패");
    }

    public void selectEmployee() {
        List<EmployeeDto> employeeDtoList = employeeService.selectAllEmployee();

        employeeDtoList.forEach(System.out::println);
    }

    public void insertEmployee() {
        System.out.println("이름 입력해주세요.");
        String name = sc.nextLine();

        System.out.println("부서 번호를 입력해주세요.");
        Long ID = sc.nextLong();
        sc.nextLine();

        EmployeeDto tmp = new EmployeeDto(null, name, ID);
        int result = employeeService.insertEmployee(tmp);

        if (result > 0) System.out.println("성공");
        else System.out.println("실패");
    }

    public void deleteEmployee() {
        System.out.println("삭제할 직원의 ID를 입력해주세요.");
        Long ID = sc.nextLong();
        sc.nextLine();

        EmployeeDto tmp = new EmployeeDto(ID, null, null);

        int result = employeeService.deleteEmployee(tmp);

        if (result > 0) System.out.println("성공");
        else System.out.println("실패");
    }

    public void updateEmployee() {
        System.out.println("수정하고 싶은 직원의 ID를 입력하세요.");
        Long ID = sc.nextLong();
        sc.nextLine();

        System.out.println("직원 이름 입력.");
        String name = sc.nextLine();

        System.out.println("개발 부서 id 입력.");
        Long dept_Id = sc.nextLong();
        sc.nextLine();

        EmployeeDto tmp = new EmployeeDto(ID, name, dept_Id);

        int result = employeeService.updateEmployee(tmp);

        if (result > 0) System.out.println("수정 성공");
        else System.out.println("수정 실패");
    }
}
