@Entity
public class Purchase {
//Identity will generate unique keys
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_id;
  //We are adding some constraints like product name is not null
    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

   
    private Double price;

    private String pictureUrl;

    private int quantity;
  
    private float mrp;
    //mrp>pricing
    // all arguments contructor 
    // standard getters and setters
}
