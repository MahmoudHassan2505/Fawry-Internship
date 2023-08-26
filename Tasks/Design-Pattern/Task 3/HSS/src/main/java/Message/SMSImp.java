package Message;

public class SMSImp implements SMS{
    private String message;
    private int phoneNumber;

    public SMSImp(String message,int phoneNumber){
        this.message=message;
        this.phoneNumber=phoneNumber;
    }

    public void send(){
        System.out.println("sending : "+ message+"\tto: "+phoneNumber);
    }

    public String getMessage() {
        return message;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

}
