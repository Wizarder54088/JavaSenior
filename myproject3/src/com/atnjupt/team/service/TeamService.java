package com.atnjupt.team.service;

import com.atnjupt.team.domain.Architect;
import com.atnjupt.team.domain.Designer;
import com.atnjupt.team.domain.Employee;
import com.atnjupt.team.domain.Programmer;

public class TeamService {
    private int counter = 1;//自动生成团队的memberId
    private final int MAX_MEMBER = 5;//开发团队的最大成员
    Programmer[] team = new Programmer[MAX_MEMBER];//团队中各个成员
    private int total;//团队的实际人数

    /**
     * @return
     * @Description 获取团中的开发成员
     * @author Wizarder
     * @date 2021年2月10日下午5:00:27
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public TeamService() {
        super();
    }

    /**
     * @param e
     * @throws TeamException
     * @Description 团队中添加成员
     * @author Wizarder
     * @date 2021年2月10日下午4:59:00
     */
    public void addMember(Employee e) throws TeamException {
//		失败信息包含以下几种：
//		成员已满，无法添加
//		该成员不是开发人员，无法添加
//		该员工已在本开发团队中
//		该员工已是某团队成员 
//		该员正在休假，无法添加
//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员

//		成员已满，无法添加
        if (total >= team.length) {
            throw new TeamException("开发团队人数已满，无法添加!");
        }
//		该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发成员");
        }
//		该员工已在本开发团队中
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                throw new TeamException("该员工已在开发团队");
            }
        }
//		该员工已是某团队成员 
//		该员正在休假，无法添加
        Programmer p = (Programmer) e;

//			if("BUSY".equals(p.getStatus())){
//				throw new TeamException("该成员已是某团队成员");
//
//			}else if("VOCATION".equals(p.getStatus())){
//				throw new TeamException("该成员正在休假");
//			}
        switch (p.getStatus()) {
            case BUSY:
                throw new TeamException("该成员已是某团队成员");

            case VOCATION:
                throw new TeamException("该成员正在休假");

        }

//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员
        //获取team中已有的成员
        int numberProgrammer = 0, numberDesigner = 0, numberArchitect = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numberArchitect++;
            } else if (team[i] instanceof Designer) {
                numberDesigner++;
            } else if (team[i] instanceof Programmer) {
                numberProgrammer++;
            }
        }
        if (p instanceof Architect) {
            if (numberArchitect >= 1) {
                throw new TeamException("该团队至多一个架构师");
            }
        } else if (p instanceof Designer) {
            if (numberDesigner >= 2) {
                throw new TeamException("该团队至多两个设计师");
            }
        } else if (p instanceof Programmer) {
            if (numberProgrammer >= 3) {
                throw new TeamException("该团队至多三个程序员");
            }
        }
        //错误的 eg 原来有两个设计师，你进来一个架构师
//		if(p instanceof Architect && numOfArch >= 1){
//			throw new TeamException("团队中至多只能有一名架构师");
//		}else if(p instanceof Designer && numOfDes >= 2){
//			throw new TeamException("团队中至多只能有两名设计师");
//		}else if(p instanceof Programmer && numOfPro >= 3){
//			throw new TeamException("团队中至多只能有三名程序员");
//		}
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    /**
     * @param memberId
     * @throws TeamException
     * @Description 从团队中删除制定的成员
     * @author Wizarder
     * @date 2021年2月10日下午4:58:35
     */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        boolean isFlag = true;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                isFlag = false;
                break;
            }

        }
        //后一个元素覆盖前一个元素，实现删除操作
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        //未找到指定memberId的情况
        if (isFlag) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        team[--total] = null;

    }
}
