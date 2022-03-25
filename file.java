import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class file extends Node{
    private static Node head;

    String FilePat = "C:\\Users\\hizar\\Documents\\BAnk\\";
    int money;
    public file(String username, long cNIC, int pin, long numbe ,String gender, String accountType, long accountID, String address,
    String FilePat) throws IOException{
    super(username, cNIC, pin, numbe, gender, accountType, accountID, address);
       Node temp = head;
        this.money=0;
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(FilePat + this.getAccountID() + ".txt",true));
            while(temp!=null){

                buffer.write(this.money + "\r\n" + this.getUsername() + "\r\n" +  this.getCNIC()+ "\r\n" +  this.getPin()+ "\r\n"+  this.getNumber()+ "\r\n"+ this.getGender()+ "\r\n" + this.getAccountType() + "\r\n" + this.getAccountID() + "\r\n" + this.getAddress()+ "\r\n");
                buffer.write("\n");
                temp = temp.next;
            }

            // System.out.println("\t\t\t\tUSER-GENERATED");
            buffer.close();


        } catch (Exception e) {
           System.out.println("unable to write in a file");
        }
       








    }

    public static void insert( String username,Long cni, int pin, long numbe, String gender, long AccountId,String accType,String addres){
        // Node node = new Node(name, username, pinNo, numb, addres);
        
        if(head==null) {
			
			Node newNode= new Node(username, cni, pin, numbe, gender, accType, AccountId, addres);
			
			head=newNode;
			newNode.next = null;
			return;
		}
		
		Node currNode=head;
		while(currNode.next!=null) {
			currNode=currNode.next;
			
		}
		
		Node newNode= new Node(username, cni,pin, numbe, gender, accType, AccountId, addres);
		currNode.next=newNode;
        
    }
        
    public static void delete() {
        head=null;
    }


    public static void message(){
        System.out.println("\t\t\t\tUser-Generated Successfully");
    }

    public static void insert(String name, String cni,int pin, long numbe, String gender, String accID, String accType, String address) {
    }







    
    
}
