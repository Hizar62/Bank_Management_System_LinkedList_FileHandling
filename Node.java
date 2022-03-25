

public class Node {

    private String Username;
    private long CNIC;
    private int pin;
    private long Number;
    private String Gender;
    private String AccountType;
    private long AccountID;
    private String Address;
    protected Node next;

    






    public Node(String username, long cNIC,int pin, Long number, String gender, String accountType, long accountID, String address) {
        Username = username;
        CNIC = cNIC;
        this.pin = pin;
        Number = number;
        Gender = gender;
        AccountType = accountType;
        AccountID = accountID;
        Address = address;
    }
    public Node(String username, long cNIC, int pin, Long number, String gender, String accountType, long accountID, String address,
            Node next) {
        Username = username;
        CNIC = cNIC;
        Gender = gender;
        this.pin = pin;
        Number = number;
        AccountType = accountType;
        AccountID = accountID;
        Address = address;
        this.next = next;
    }


    
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public long getNumber() {
        return Number;
    }
    public void setNumber(long number) {
        Number = number;
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public long getCNIC() {
        return CNIC;
    }
    public void setCNIC(long cNIC) {
        CNIC = cNIC;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public String getAccountType() {
        return AccountType;
    }
    public void setAccountType(String accountType) {
        AccountType = accountType;
    }
    public long getAccountID() {
        return AccountID;
    }
    public void setAccountID(long accountID) {
        AccountID = accountID;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    






}
