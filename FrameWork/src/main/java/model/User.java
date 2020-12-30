package model;

public class User {
    private String email;
    private String firstName;
    private String telephone;

    private String promo;
    public User(String promo, String firstName, String email, String telephone) {
        this.promo= promo;
        this.firstName=firstName;
        this.email=email;
        this.telephone=telephone;
    }
    public String getPromo(){
        return promo;
    }
    public String getEmail(){
        return email;
    }
    public String getTelephone(){
        return telephone;
    }
    public String getFirstName(){
        return firstName;
    }


}
