@Entity
public class Customer {
//Identity will generate unique keys
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_id;
  //We are adding some constraints like product name is not null
    @NotNull(message = "Customer name is required.")
    @Basic(optional = false)
    private String name;

   @NotNull(message = "Email is required.")
    @Basic(optional = false)
    private String email;
  
  @NotNull(message = "Phone number is required.")
    @Basic(optional = false)
    private long phno;
  
   private String address;
    //Using Get and Set methods to access private variables
    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }
    
    public long getId(){
        return cust_id;
    }
    public String getemailid() {
        return email;
    }

    public void setemailid(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    // all arguments contructor 
    // standard getters and setters
}
