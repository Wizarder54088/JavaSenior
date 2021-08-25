package com.atnjupt.team.service;

import com.atnjupt.team.domain.Architect;
import com.atnjupt.team.domain.Designer;
import com.atnjupt.team.domain.Employee;
import com.atnjupt.team.domain.Equipment;
import com.atnjupt.team.domain.NoteBook;
import com.atnjupt.team.domain.PC;
import com.atnjupt.team.domain.Printer;
import com.atnjupt.team.domain.Programmer;

import static com.atnjupt.team.service.Data.*;

/**
 * @author Wizarder Email:472983012@qq.com
 * @Description 功能：负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @date 2021年2月9日下午8:53:46
 */
public class NameListService {
    private Employee[] employees;
    // 根据项目提供的Data类构建相应大小的employees数组
    // 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
    // 将对象存于数组中
    // Data类位于com.atguigu.team.service包中

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            // 获取通用的属性
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            int salary = Integer.parseInt(EMPLOYEES[i][4]);
            int type = Integer.parseInt(EMPLOYEES[i][0]);// 获取存储的员工类型
            Equipment equipment;
            double bonus;
            int stock;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;

                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;

                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;

                case ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;

            }

        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("该员工不存在");
    }

    public Equipment creatEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);

        switch (type) {
            case PC:
                return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
            case NOTEBOOK:
                return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
            case PRINTER:
                return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
        }
        return null;
    }
}
