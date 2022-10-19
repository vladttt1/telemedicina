package PatientAccount;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BankProgram {


        private final HashMap<Integer,Integer>accounts=new HashMap<>();
        private final double rate=0.02;
        private int current=-1;
        private  int nextacct=0;
        private Scanner scanner;
        private boolean done=false;


        public void run(){
        scanner=new Scanner((System.in));
        while(!done) {
            System.out.println(("Enter command(0=qite,1=new, 2=select,3=deposit,4=loan,5=show,6=interest,):"));
            int cmd = scanner.nextInt();
            processCommand(cmd);
            System.out.println("YOU PUSHED CMD " + cmd);
        }scanner.close();}
        private void processCommand(int cmd){

    if(cmd==0)quit();
    else if(cmd==1)newAccount();
    else if (cmd==2)select();
    else  if (cmd==3)deposit();
    else  if (cmd==4)authorizeLoan();
    else if (cmd==5)showAll();
    else if (cmd==6)addInterest();
    else
        System.out.println("Illegal command");}
    private void quit(){done=true;
    System.out.println("GoodBue!");}
    private  void newAccount(){current=nextacct++;
    accounts.put(current,0);
    System.out.println(("Your new account number is  "   +   current));}
    private  void select(){
        System.out.println("Enter your account # ");
        current =scanner.nextInt();
        int balance=accounts.get(current);
        System.out.println("Your balance  of account "  +  current +"\n is "+ balance);}
        private  void deposit(){
            System.out.println("Enter deposit amount");
            int amt=scanner.nextInt();
            int  balance=accounts.get(current);
            accounts.put(current,amt+balance);}
            private void authorizeLoan() {
                System.out.println("Enter loan amount");
                int loanamt = scanner.nextInt();
                int balance = accounts.get(current);
                if (balance >= loanamt / 2)
                    System.out.println(" Loan is apprved!");
                else System.out.println("Loan not approved! Sorry!");
            }
            private  void  showAll(){
        Set<Integer> acts=accounts.keySet();
        System.out.println(" The bank has "  + ""+
            accounts.size() +""+ " accounts");
                System.out.println("ALL ACCOUNTS REPORT " + accounts.toString());
        acts.stream().filter(s->s>10).forEach(s->System.out.println(s + " THERE ARE ALL ACCOUNTS"));

            }

            private void  addInterest(){

  Set<Integer>accts=accounts.keySet();
                for (int i:accts)
                      {
      int balance=accounts.get(i);
      int newBalance=(int)(balance*(1+rate));
      accounts.put(i,newBalance);}
                int balance=accounts.get(current);
    System.out.println("YOU ADDED INTEREST");
    System.out.println(accounts.toString());
    }}








	// write your code here


