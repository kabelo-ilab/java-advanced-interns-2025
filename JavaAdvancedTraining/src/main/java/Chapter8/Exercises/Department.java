package Chapter8.Exercises;

public class Department {
    private String departmentName;
    private int departmentId;
    private int maxEmployees;

    public Department(String departmentName, int departmentId, int maxEmployees) throws DepartmentException {
        setDepartmentName(departmentName);
        setDepartmentId(departmentId);
        setMaxEmployees(maxEmployees);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) throws DepartmentException {
        if (departmentName == null || departmentName.length() != 2) {
            throw new DepartmentException(departmentName, departmentId, maxEmployees,
                    "Department name must consist of exactly two letters.");
        }
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) throws DepartmentException {
        if (departmentId < 100 || departmentId > 499) {
            throw new DepartmentException(departmentName, departmentId, maxEmployees,
                    "Department ID must be a 3-digit number between 100 and 499.");
        }
        this.departmentId = departmentId;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) throws DepartmentException {
        if (maxEmployees < 4 || maxEmployees > 10) {
            throw new DepartmentException(departmentName, departmentId, maxEmployees,
                    "Number of employees must be between 4 and 10.");
        }
        this.maxEmployees = maxEmployees;
    }

    @Override
    public String toString() {
        return String.format("""
                Department{Name: %s [%d], Max Employees: %d}""",
                getDepartmentName(), getDepartmentId(), getMaxEmployees());
    }
}
