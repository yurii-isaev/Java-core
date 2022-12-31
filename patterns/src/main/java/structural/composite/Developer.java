package structural.composite;

// Leaf class
class Developer implements Employee {
   private String name;
   private String position;

   public Developer(String name, String position) {
      this.name = name;
      this.position = position;
   }

   public void showDetails() {
      System.out.println("Name: " + name + ", Position: " + position);
   }
}
