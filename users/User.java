package users;

import resources.Resource;

public class User {
    protected String name;
    protected String surname;
    protected int idUser;
    protected String department;
    private int fee; // Or other properties relevant to fee calculation


    public User(String name, String surname, int idUser, String department) {
        this.name = name;
        this.surname = surname;
        this.idUser = idUser;
        this.department = department;
        this.fee = fee;

    }

    public String getName (){
        return name;
    }

    public String  getSurname (){
        return surname;
    }

    public int getFee(Resource[] resources) {
        // Implement fee calculation logic here
        int totalFee = 0;

        // Example fee calculation based on resources (adjust as needed)
        for (Resource resource : resources) {
            if (resource.isOverdue()) { // Check if resource is overdue
                totalFee += 5; // Add a 5 zł fee for overdue resources (example logic)
            }
        }

        return totalFee; // Return the calculated fee
    }

    public int numberOfResources(Resource[] resources) {
        return resources.length;  // Return the number of resources in the array
    }
}

