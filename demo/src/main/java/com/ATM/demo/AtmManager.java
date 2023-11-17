    package com.ATM.demo;
    import java.time.LocalDate;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Optional;

import org.springframework.stereotype.Service;

    import jakarta.annotation.Resource;
    import jakarta.servlet.http.HttpServletRequest;
    

    @Service
    public class AtmManager {

    @Resource
    private AtmRepository atmRepository;

    public Map<String, Object> authenticateUsers(HttpServletRequest formData) {

    Map<String, Object> res = new HashMap<>();

    String accountNumber = formData.getParameter("accountNumber");
    String accountPin = formData.getParameter("accountPin");  


    AtmModal activeAccounts = atmRepository.findByAccountNumberAndStatus(accountNumber,  "Active");

    if(activeAccounts != null) {
    res.put("STATUS" ,"SUCCESS");
    res.put("message", "Account found. Click ok to continue");
    return res;
    }

    res.put("STATUS","ERROR");
    res.put("message","Account not Found. Check Credentials and try again");
    return res;

    }

    public Map<String,Object> saveAmount(HttpServletRequest request){

         Map<String, Object> finalResponse = new HashMap<>();
          String amount = request.getParameter("depositAmount");
          Long amountDeposited = Long.parseLong(amount);

          AtmModal atmModal = new AtmModal();

          atmModal.setAccountBalance(amountDeposited);

          finalResponse.put("status","SUCCESS");
          finalResponse.put("message", "Amount successfuly deposited");

        return finalResponse;

    }


    public Map<String,Object> createUserAccount(HttpServletRequest formData){

    Map<String, Object> response = new HashMap<>();

    String firstName = formData.getParameter("firstName");
    String lastName = formData.getParameter("lastName");
    String account = formData. getParameter("accountNumber");
    String pin = formData.getParameter("accountPin");

    AtmModal atmModal = new AtmModal();

    atmModal.setAccountNumber(account);
    atmModal.setAccountPin(pin);
    atmModal.setFirstName(firstName);
    atmModal.setLastName(lastName);
    atmModal.setStatus("ACTIVE");
    atmModal.setCreatedDate(LocalDate.now());

    atmRepository.save(atmModal);

    response.put("status","SUCCESS");
    response.put("message","Account Successfully created");
    return response;
    

   }


    public AtmModal getExistingUser(Long id) {

       AtmModal currentUser =  atmRepository.findById(id);
        return currentUser;
    }

    public Map<String,Object> withdrawAmount(HttpServletRequest request) {

      Map<String,Object> finalResponse = new HashMap<>();

      String amount = request.getParameter("withdraw");
      String user = request.getParameter("Id");
      Long amountWithdrawn = Long.parseLong(amount);
      Long  Id = Long.parseLong(user);

    AtmModal currentUser =  atmRepository.findById(Id);
       Long currentAmount = currentUser.getAccountBalance(); 
       Long newAmount = currentAmount - amountWithdrawn;

    
      currentUser.setAccountBalance(newAmount);

      atmRepository.save(currentUser);
     
      finalResponse.put("status", "SUCCESS");
      finalResponse.put("message","Amount Successfully Withdrawn");

       return finalResponse;
    }

}