package structural.composite;

import java.util.ArrayList;
import java.util.List;

// Composite class
class Manager implements Employee {
   private String name;
   private String position;
   private List<Employee> team;

   public Manager(String name, String position) {
      this.name = name;
      this.position = position;
      this.team = new ArrayList<>();
   }

   public void addEmployee(Employee employee) {
      team.add(employee);
   }

   public void removeEmployee(Employee employee) {
      team.remove(employee);
   }

   public void showDetails() {
      System.out.println("Name: " + name + ", Position: " + position);
      System.out.println("Team Members:");
      for (Employee employee : team) {
         employee.showDetails();
      }
   }
}
