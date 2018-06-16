package test;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        Map<Integer,BankAccount> accounts = new HashMap<>();
        while (!"end".equalsIgnoreCase(line)){



            doAction(accounts,line);

            line=reader.readLine();
        }

    }
    private static void doAction(Map<Integer, BankAccount> accounts, String line) {

        String [] data = line.split(" ");

        String command = data[0];
        int account;
        double money;
        switch (command){
            case "Deposit":
                account = Integer.parseInt(data[1]);
                money = Integer.parseInt(data[2]);
                try {
                    accounts.get(account).deposit(money);
                    System.out.printf("Deposited %.0f to ID%d%n",money,account);
                }catch (Exception e){
                    System.out.println("Account does not exist");
                }
                break;
            case "Create":

                test.BankAccount acc = new BankAccount();
                account = acc.getId();
                if (!accounts.containsKey(account)){

                    accounts.put(account,acc);
                    System.out.printf("Account ID%d created%n",account);
                }else {
                    System.out.println("Account already exists");
                }
                break;




            case "Print":
                account = Integer.parseInt(data[1]);

                try {
                    System.out.println(accounts.get(account).toString());
                }catch (Exception e){
                    System.out.println("Account does not exist");
                }

                break;

            case "SetInterest":
                BankAccount.setInterest(Integer.parseInt(data[1]));

                break;
            case "GetInterest":
                try {
                    System.out.printf("%.2f%n",accounts.get(Integer.parseInt(data[1])).getInterest(Integer.parseInt(data[2])));

                }catch (Exception e){
                    System.out.println("Account does not exist");
                }
                break;


        }
    }
}
