@Entity
public class Purchase {
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
    // all arguments contructor 
    // standard getters and setters
}
