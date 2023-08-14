package Proxy;

public class CommandExecuterProxy implements CommandExecuterI{
    private boolean isAdmin;
    private CommandExecuterImp commandExecuter;

    public CommandExecuterProxy(String username,String password){
        isAdmin = (username.equalsIgnoreCase("admin") && password.equals("123"));

    }
    @Override
    public void run(String cmd) {
        if (isAdmin){
            commandExecuter =new CommandExecuterImp();
            commandExecuter.run(cmd);
        }else
            throw new RuntimeException("Not Admin");



    }
}
