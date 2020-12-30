package service;

import model.Good;

public class GoodCreator {
    public static final String TESTDATA_GOOD_ARTICLE = "testdata.good.article";
    public static final String TESTDATA_GOOD_PRICE = "testdata.good.price";
    public static final String TESTDATA_GOOD_COUNT = "testdata.good.count";
    public static final String TESTDATA_GOOD_SIZE = "testdata.good.size";
    public static final String USER_OPTCOUNT = "testdata.good.optcount";
    public static final String TESTDATA_SECGOOD_ARTICLE = "testdata.good.secarticle";
    public static final String TESTDATA_SECGOOD_PRICE = "testdata.good.secprice";
    public static final String TESTDATA_SECGOOD_COUNT = "testdata.good.seccount";
    public static final String TESTDATA_SECGOOD_SIZE = "testdata.good.secsize";
    public static final String TESTDATA_GOOD_FINAL_PRICE = "testdata.good.finalprice";

    public static Good withCredentialsFromProperty(){
        return new Good(TestDataReader.getTestData(TESTDATA_GOOD_SIZE), TestDataReader.getTestData(TESTDATA_GOOD_ARTICLE), TestDataReader.getTestData(TESTDATA_GOOD_COUNT), TestDataReader.getTestData(TESTDATA_GOOD_PRICE),TestDataReader.getTestData(TESTDATA_GOOD_FINAL_PRICE),TestDataReader.getTestData(USER_OPTCOUNT));
    }

    public static Good secondWithCredentialsFromProperty(){
        return new Good(TestDataReader.getTestData(TESTDATA_SECGOOD_SIZE), TestDataReader.getTestData(TESTDATA_SECGOOD_ARTICLE), TestDataReader.getTestData(TESTDATA_SECGOOD_COUNT), TestDataReader.getTestData(TESTDATA_SECGOOD_PRICE),TestDataReader.getTestData(TESTDATA_GOOD_FINAL_PRICE),TestDataReader.getTestData(USER_OPTCOUNT));
    }

}
