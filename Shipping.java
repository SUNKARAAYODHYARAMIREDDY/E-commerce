@Entity
public class Shipping {
//Identity will generate unique keys
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_id;
  //We are adding some constraints like product name is not null
    @NotNull(message = "Pincode is required.")
    @Basic(optional = false)
    private String pincode;

   private String address;
  
   private String city;
    
   public String getCity() {
        return city;
    }

    public void setPincode(String city) {
        this.city = city;
    }
   //Using Get and Set methods to access private variables
    // all arguments contructor 
    // standard getters and setters
   
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

       
       
}
