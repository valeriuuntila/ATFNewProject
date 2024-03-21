package api.dtos;

public class EmployeeData {
    private Integer id;
    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;

    public EmployeeData() {
    }

    public EmployeeData(Integer id, String employee_name, Integer employee_salary, Integer employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public Integer getId() {
        return id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }
}
