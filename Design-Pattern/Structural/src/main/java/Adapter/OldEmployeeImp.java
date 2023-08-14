package Adapter;

public class OldEmployeeImp implements OldEmplyeeI{
    private String firstname;
    private String lastname;
    private double salay;

    public OldEmployeeImp(String firstname,String lastname,double salay){
        this.salay=salay;
        this.firstname=firstname;
        this.lastname=lastname;
    }



    @Override
    public String getFirstname() {
        return this.firstname;
    }

    @Override
    public String getLastname() {
        return this.lastname;
    }

    @Override
    public double getSalary() {
        return this.salay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salay=" + salay +
                '}';
    }
}
