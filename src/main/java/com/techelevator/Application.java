package com.techelevator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Application {

    private List<Department> departments = new ArrayList<Department>();
    private List<Employee> employees = new ArrayList<Employee>();
    private Map<String, Project> projCollection = new HashMap<String, Project>();

    /**
     * The main entry point in the application
     * @param args
     */

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department marketing = new Department(1, "Marketing");
        departments.add(marketing);
        Department sales = new Department(2, "Sales");
        departments.add(sales);
        Department engineering = new Department(3, "Engineering");
        departments.add(engineering);
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department dept : departments) {
            System.out.println(dept.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        LocalDate today = LocalDate.now();

        Employee deanJohnson = new Employee();
        deanJohnson.setEmployeeId(1);
        deanJohnson.setFirstName("Dean");
        deanJohnson.setLastName("Johnson");
        deanJohnson.setEmail("djohnson@teams.com");
        deanJohnson.setSalary(60000.00);
        deanJohnson.setDepartment(departments.get(2));
        deanJohnson.setHireDate(today);
        employees.add(0, deanJohnson);

        Employee angieSmith = new Employee(2, "Angie", "Smith", "asmith@teams.com", getDepartmentByName("Engineering"), today);
        employees.add(1, angieSmith);

        Employee margaretThompson = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", getDepartmentByName("Marketing"), today);
        employees.add(2, margaretThompson);

        angieSmith.raiseSalary(10.0);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (Employee emp : employees) {
            System.out.print(emp.getFullName() + " (" + currency.format(emp.getSalary()) + ") " + emp.getDepartment().getName() + "\n");
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project teamsProject = new Project("TEams", "Project Management Software", LocalDate.now(), LocalDate.now().plusDays(30));

        for (Employee emp : employees) {
            if (emp.getDepartment().getDepartmentId() == 3) {
                teamsProject.addTeamMember(emp);
            }
        }

        projCollection.put("TEams", teamsProject);

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project landingPageProject = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", LocalDate.now().plusDays(31), LocalDate.now());
        landingPageProject.setDueDate(landingPageProject.getStartDate().plusDays(7));
        for (Employee emp : employees) {
            if (emp.getDepartment().getDepartmentId() == 1) {
                landingPageProject.addTeamMember(emp);
            }
        }

        projCollection.put("Marketing Landing Page", landingPageProject);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (String thisProject : projCollection.keySet()) {
            System.out.print(thisProject + ": ");
            System.out.print(projCollection.get(thisProject).getTeamMembers().size() + "\n");
        }

    }

    private Department getDepartmentByName(String deptName) {
        for (Department dept : departments) {
            if ( deptName.equals( dept.getName() ) ) {
                return dept;
            }

        }
        return null;
    }

}
