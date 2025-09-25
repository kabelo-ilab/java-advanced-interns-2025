package Chapter8.Exercises;

public class DepartmentException extends Exception{
    public DepartmentException(String department, int departmentId, int maxEmployees, String message) {
        super("Failed to create Department [" + department + " (" +departmentId + ")" +
                " - Max Employees: " + maxEmployees + "] - " + message);
    }
}
