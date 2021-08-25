package com.atnjupt.team.domain;

import com.atnjupt.team.service.Status;

public class Programmer extends Employee {
    private int memberId;//团队id
    private Status status = Status.FREE;//状态
    private Equipment equipment;//成员领用的设备。

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);


        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer() {
        super();
    }

    public String getTeamBaseMessage() {
        return memberId + "/" + super.getBaseMessage() + "\t程序员\t";
    }

    @Override
    public String toString() {

        return super.toString() + "\t程序员\t" + status;
    }

}
