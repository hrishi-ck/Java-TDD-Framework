package structure;

public class LeadDetails {
   private String firstName; 
   private String lastName;
   private String companyName; 
   private String phoneNumber; 
   private String email;

   public void setFirstName(String firstName){
    this.firstName = firstName;
   }
   public void setLastName(String lastName){
    this.lastName = lastName;
   }
   public void setCompanyName(String companyName){
    this.companyName = companyName;
   }
   public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
   }
   public void setEmail(String email){
    this.email = email;
   }


   public String getFirstName(){
    return firstName;
   }
   public String getLastName(){
    return lastName;
   }
   public String getCompanyName(){
    return companyName;
   }
   public String getPhoneNumber(){
    return phoneNumber;
   }
   public String getEmail(){
    return email;
   }
}
