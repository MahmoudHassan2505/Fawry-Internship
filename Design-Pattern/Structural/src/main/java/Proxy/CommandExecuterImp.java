package Proxy;

public class CommandExecuterImp implements CommandExecuterI{
    @Override
    public void run(String cmd) {
        System.out.println(cmd+" Run succefully");

    }
}
