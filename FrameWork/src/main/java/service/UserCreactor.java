package service;

import model.Good;
import model.User;

public class UserCreactor {
    public static final String USER_VALID_EMAIL = "testdata.user.validemail";
    public static final String USER_INVALID_EMAIL = "testdata.user.invalidemail";
    public static final String USER_TELEPHONE = "testdata.user.telephone";
    public static final String USER_FIRSTNAME = "testdata.user.firstname";
    public static final String USER_VALID_PROMO = "testdata.user.validpromo";
    public static final String USER_INVALID_PROMO = "testdata.user.promo";

    public static User createValidUser(){
        return new User(TestDataReader.getTestData(USER_VALID_PROMO),TestDataReader.getTestData(USER_FIRSTNAME),TestDataReader.getTestData(USER_VALID_EMAIL),TestDataReader.getTestData(USER_TELEPHONE));
    }
    public static User createInvalidUser(){
        return new User(TestDataReader.getTestData(USER_INVALID_PROMO),TestDataReader.getTestData(USER_FIRSTNAME),TestDataReader.getTestData(USER_INVALID_EMAIL),TestDataReader.getTestData(USER_TELEPHONE));
    }


}
