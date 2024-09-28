package com.gwnu.mybatis.chap03.sub01.using_interface;

import com.gwnu.mybatis.chap03.sub01.using_interface.model.dto.EmployeeDto;
import com.gwnu.mybatis.chap03.sub01.using_interface.model.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    private static final EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        while(true) {
            System.out.println("=========== 직원 관리 ===========");
            System.out.println("1. 신규 직원 등록");
            System.out.println("2. 직원 정보 수정");
            System.out.println("3. 직원 정보 삭제");
            System.out.println("4. 직원 정보 조회");
            System.out.println("5. 프로그램 종료");
            System.out.println("================================");

            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu) {
                case 1:
                    insertNewEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    selectEmployee();
                    break;
                case 5:
                    exit(0);
                default:
                    break;
            }
        }
    }

    private static void insertNewEmployee() {
        System.out.println("=========== 직원 등록 ===========");
        System.out.println("직원 이름을 입력하세요: ");
        String employeeName = sc.nextLine();

        // 부서 목록 출력
        // 부서 id 을 입력받도록(부서 번호)
        employeeService.selectDepartmentList().forEach(System.out::println);
        System.out.println("부서 번호를 입력하세요: ");
        Long departmentId = sc.nextLong();
        sc.nextLine();

        // 이제 회원 등록하기
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName(employeeName);
        employeeDto.setDepartmentId(departmentId);

        int result = employeeService.insertNewEmployee(employeeDto);
        if(result > 0) System.out.println("직원 등록 성공");
        else System.out.println("직원 등록 실패");
    }

    private static void updateEmployee() {
        System.out.println("=========== 직원 수정 ===========");

        employeeService.selectAllEmployeeList().forEach(System.out::println);

        System.out.println("수정할 직원의 번호를 입력하세요.");
        Long employeeId = sc.nextLong();
        sc.nextLine();

        System.out.print("이름 : ");
        String employeeName = sc.nextLine();

        System.out.print("부서 : ");
        Long departmentId = sc.nextLong();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employeeId);
        employeeDto.setEmployeeName(employeeName);
        employeeDto.setDepartmentId(departmentId);

        int result = employeeService.updateEmployee(employeeDto);
        if(result > 0) System.out.println("직원 등록 성공");
        else System.out.println("직원 등록 실패");
        // 등록된 직원들 보여주고 아이디 입력받아서 그 ID의 직원 이름, 부서 다시 입력하게 만들기
    }
    private static void deleteEmployee() {
        System.out.println("=========== 직원 삭제 ===========");

        employeeService.selectAllEmployeeList().forEach(System.out::println);

        System.out.println("삭제할 직원의 번호를 입력하세요.");
        Long employeeId = sc.nextLong();
        sc.nextLine();

        int result = employeeService.deleteEmployee(employeeId);
        if (result > 0) System.out.println("직원 삭제 성공");
        else System.out.println("직원 삭제 실패");
        // id 입력받아서 해당하는 직원 삭제하기

    }
    private static void selectEmployee() {
        System.out.println("=========== 직원 조회 ===========");

        // 부서별 조회...?
        // 이름 검색으로 조회..?
        // 직원 번호 조회..?
        // 뭘로 하징

        System.out.println("조회할 직원의 이름을 입력하세요.");
        String employeeName = sc.nextLine();

        List<EmployeeDto> employeeDtoList = employeeService.selectEmployeeList(employeeName);
        if (employeeDtoList.isEmpty()) System.out.println("해당하는 직원이 존재하지 않습니다.");
        else {
            employeeDtoList.forEach(System.out::println);
            System.out.println("직원 조회 성공");
        }

    }
}
