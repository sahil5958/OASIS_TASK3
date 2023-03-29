import java.util.*;

class bankaccount{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter the name : ");
        ATM.name=sc.nextLine();
        System.out.println("Enter the  username : ");
        String user=sc.nextLine();
        System.out.println("Enter the password : ");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number : ");
        ATM.accnumber=sc.nextLine();
        System.out.println("---------------------------");
        System.out.println("REGISTRATION SUCCESSFULLY!");
        System.out.println("---------------------------");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("sorry! Enter again!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.print("Enter the amount to withdraw : ");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance)
        {
            ATM.balance=ATM.balance-wcash;
            ATM.history.add("Withdraw");
            ATM.history.add(Integer.toString(wcash));
            System.out.println("Amount Rs."+wcash+"/- withdraw successfully");
            System.out.println("---------------------------");
        }
        else
        {
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATM.prompt();
    }
    static void deposit()
   {
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.print("Enter the amount to deposit : ");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add("Deposit");
        ATM.history.add(Integer.toString(dcash));
        System.out.println("Amount Rs."+dcash+"/- deposit has been successfully!");
        System.out.println("---------------------------");
        ATM.prompt();
    }
    static void transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiving body:");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiving body: ");
        long num=sc.nextLong();
        System.out.print("Enter the amount to be transferred : ");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance)
       {
            ATM.balance=ATM.balance-tcash;
            ATM.history.add("transferred");
            ATM.history.add(Integer.toString(tcash));
            System.out.println("Amount Rs."+tcash+"/- transferred successfully");
            System.out.println("---------------------------");
        }
        else
        {
            System.out.println("insufficient balance to transfer the cash");
            System.out.println("---------------------------");
        }
    }
}
class check{
    static void checkbalance()
     {
        System.out.print("The available balance in the bank account is : ");
        ATM.showbalance();
        System.out.println("---------------------------");
        ATM.prompt();
    }
}
class his
{
    static void transactionhistory()
{
            System.out.println("---------------------------");
            System.out.println("Your Transaction History :");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("");
            }
                System.out.println("---------------------------");
            }
            else {
                System.out.println("No enough money on your account");
            }
            ATM.prompt();
    }
}
class ATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\033[H\033[2J");
        
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("Please select the option :");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter choice : ");
        int choice =sc.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else if(choice == 2)
        {
            System.out.println("Enter your Account number : ");
            int an = sc.nextInt();

           

            if (an == 3646 )
            { 
                System.out.println("Enter password : ");
                String pa = sc.next();

                if ( pa.equals("Chetan") )
                {
                    ATM.prompt();
                }
                else
                {
                    System.out.println("--...Enter the Correct Password...--");
                }
            }            
            else
            {
                System.out.println("--... Enter Correct Account Number ....--");
            }
        }
        else {
            if(choice==3){
                System.exit(0);
            }
            else{
                System.out.println("select a value only from the given options :");
                homepage();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM SYSTEM");
        System.out.println("---------------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw the amount");
        System.out.println("2. Deposit the amount");
        System.out.println("3. Transfer the amount");
        System.out.println("4. Check balance of account");
        System.out.println("5. Transaction History of account");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}
