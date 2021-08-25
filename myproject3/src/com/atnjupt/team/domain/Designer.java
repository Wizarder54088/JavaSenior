package com.atnjupt.team.domain;

import javax.swing.plaf.metal.MetalMenuBarUI;

import com.atnjupt.team.service.Status;

public class Designer extends Programmer {

    private double bonus;//奖金

    public Designer(int id, String name, int age, double salary, Equipment equipment,
                    double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public Designer() {
        super();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String getTeamBaseMessage() {

        return getMemberId() + "/" + super.getBaseMessage() + "\t设计师\t" + bonus;
    }

    @Override
    public String toString() {

        return super.getBaseMessage() + "\t设计师\t" + getStatus() + "\t" + bonus;
    }


}
