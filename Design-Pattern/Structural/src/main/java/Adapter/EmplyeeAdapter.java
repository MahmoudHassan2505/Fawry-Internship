package Adapter;

public class EmplyeeAdapter implements OldEmplyeeI{

    NewEmplyee newEmplyee;
    public EmplyeeAdapter(NewEmplyee newEmplyee){
        this.newEmplyee= newEmplyee;
    }
    @Override
    public String getFirstname() {
        return newEmplyee.getFirstName();
    }

    @Override
    public String getLastname() {
        return newEmplyee.getSurName();
    }

    @Override
    public double getSalary() {
        return newEmplyee.getWage();
    }

    @Override
    public String toString() {
        return "Emplyee{" +
                "firstname='" + newEmplyee.getFirstName() + '\'' +
                ", lastname='" + newEmplyee.getSurName() + '\'' +
                ", salay=" + newEmplyee.getWage() +
                '}';
    }
}
