package edu.iss.lapsnew.javabeans;


import java.util.ArrayList;

import edu.iss.lapsnew.model.Employee;
import edu.iss.lapsnew.model.Leavel;

public class EmployeeLeaves  {

    private Employee employee = null;
    private ArrayList<Leavel> leaves = null;

    public EmployeeLeaves() {
    }

    public void setEmployee (Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee () {
        return employee;
    }

    public void setLeaves (ArrayList<Leavel> leaves) {
        this.leaves = leaves;
    }

    public ArrayList<Leavel> getLeaves (){
        return leaves;
    }

}