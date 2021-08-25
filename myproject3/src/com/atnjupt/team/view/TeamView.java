package com.atnjupt.team.view;

import com.atnjupt.team.domain.Employee;
import com.atnjupt.team.domain.Programmer;
import com.atnjupt.team.service.NameListService;
import com.atnjupt.team.service.TeamException;
import com.atnjupt.team.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        boolean loopFlag = true;
        char menuSelection = 0;
        while (loopFlag) {
            if (menuSelection != '1') {
                System.out.println("-------------------------------开发团队调度软件--------------------------------\n");
                System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
                listAllEmployees();
            }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");


            menuSelection = TSUtility.readMenuSelection();

            switch (menuSelection) {

                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deletMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char confirmSelection = TSUtility.readConfirmSelection();
                    if (confirmSelection == 'Y') {
                        loopFlag = false;
                    } else if (confirmSelection == 'N') {
                        break;
                    }

            }
        }

    }

    /**
     * @Description 列出所有公司成员
     * @author Wizarder
     * @date 2021年2月10日下午5:17:40
     */
    public void listAllEmployees() {

        Employee[] allEmployees = listSvc.getAllEmployees();
        if (allEmployees.length == 0) {
            System.out.println("没有客户!");
        }
        for (int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i]);
        }
    }

    /**
     * @Description 获取开发团队的信息
     * @author Wizarder
     * @date 2021年2月10日下午5:44:25
     */
    private void getTeam() {
        // System.out.println("开发团队");
        System.out.println("--------------------团队成员列表---------------------");
        Programmer[] team = teamSvc.getTeam();
        if (team.length == 0 || team == null) {
            System.out.println("开发团队目前没有成员！");
            return;
        }
        System.out.println("TID/ID\t姓名\t年龄	工资\t职位	奖金\t股票");
        for (int i = 0; i < team.length; i++) {
            System.out.println(team[i].getTeamBaseMessage());
        }

    }

    /**
     * @Description 从公司列表中添加成员
     * @author Wizarder
     * @date 2021年2月10日下午5:29:00
     */
    private void addMember() {
        // System.out.println("添加团队成员");
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();

        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功");

        } catch (TeamException e) {

            System.out.println("添加失败，原因：" + e.getMessage());

        }
        TSUtility.readReturn();

    }

    /**
     * @Description 删除团队成员
     * @author Wizarder
     * @date 2021年2月10日下午7:34:43
     */
    private void deletMember() {
        // System.out.println("删除团队成员");

        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除的员工TID：");
        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char confirmSelection = TSUtility.readConfirmSelection();
        if (confirmSelection == 'Y') {

            try {
                teamSvc.removeMember(memberId);
                System.out.println("删除成功");

            } catch (TeamException e) {

                System.out.println("删除失败，原因：" + e.getMessage());

            }
            TSUtility.readReturn();
        }

        return;

    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
