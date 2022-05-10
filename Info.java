@RequestMapping(value = { "/Info" }, method = RequestMethod.GET)
   public String Info(Model model) {

      UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      System.out.println(Customer.getId());
      System.out.println(Customer.getName());
      model.addAttribute("Details", Customer);
      return "Info";
   }

   @RequestMapping(value = { "/Purchase" }, method = RequestMethod.GET)
   public String orderList(Model model, //
         @RequestParam(value = "page", defaultValue = "1") String pageStr) {
      int page = 1;
      try {
         page = Integer.parseInt(pageStr);
      } catch (Exception e) {
      }
      final int MAX_RESULT = 5;
      final int MAX_NAVIGATION_PAGE = 10;

      PaginationResult<OrderInfo> paginationResult //
            = orderDAO.listOrderInfo(page, MAX_RESULT, MAX_NAVIGATION_PAGE);

      return "orderList";
   }

   // GET: Show product.
   @RequestMapping(value = { "/Product" }, method = RequestMethod.GET)
   public String product(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
      ProductForm productForm = null;

      if (code != null && code.length() > 0) {
         Purchase purchase = PurchaseDAO.getid(id);
         if (Purchase != null) {
            PurchaseForm = new Product(product);
         }
      }
      
      model.addAttribute("productForm", productForm);
      return "product";
   }

   // POST: Save product
   @RequestMapping(value = { "/product" }, method = RequestMethod.POST)
   public String productSave(Model model, //
         @ModelAttribute("productForm") @Validated ProductForm productForm, //
         BindingResult result, //
         final RedirectAttributes redirectAttributes) {

      if (result.hasErrors()) {
         return "product";
      }
      try {
         productDAO.save(productForm);
      } catch (Exception e) {
         Throwable rootCause = ExceptionUtils.getRootCause(e);
         String message = rootCause.getMessage();
         model.addAttribute("errorMessage", message);
         // Show product form.
         return "Purchase";
      }

      return "redirect://Purchase";
   }

   @RequestMapping(value = { "/Shipping" }, method = RequestMethod.GET)
   public String orderView(Model model, @RequestParam("Id") String Id) {
       Shipping orderInfo = null;
      if (Id != null) {
         orderInfo = this.orderDAO.getShipping(orderId);
      }
     
      List<OrderDetailInfo> details = this.orderDAO.listOrderDetailInfos(orderId);
      orderInfo.setDetails(details);

      model.addAttribute("Shipping", Shipping);

      return "Shipping";
   }

}
