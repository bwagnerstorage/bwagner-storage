import java.util.*;

public class EmployeeTest
{
    public EmployeeTest()
    {
        Company company = new Company(62, 25, 50000);
        company.addEmployee(new JohnWayne());
        company.addEmployee(new JimmyStewart());
        company.addEmployee(new MarilynMonroe());
        company.addEmployee(new AlanLadd());
        company.addEmployee(new HenryFonda());
        company.addEmployee(new MaureenOHare());
        company.addEmployee(new LeeMarvin());

        System.out.println("Employee List");
        System.out.println("=============");
        company.printList();

        company.processRetirements();

        System.out.println("Process Retirement List");
        System.out.println("=======================");
        company.printList();
    }

    public static void main(String[] args)
    {
        EmployeeTest test = new EmployeeTest();
    }
}