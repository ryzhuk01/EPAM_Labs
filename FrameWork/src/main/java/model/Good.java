package model;

public class Good {
    private String size;
    private String article;
    private String count;
    private String price;
    private String finalPrice;
    private String optCount;

    public Good(String size, String article, String count, String price,String finalPrice,String optCount) {
        this.article = article;
        this.count = count;
        this.size = size;
        this.price = price;
        this.finalPrice = finalPrice;
        this.optCount=optCount;

    }
    public String getOptCount(){
        return optCount;
    }
    public String getFinalPrice(){
        return finalPrice;
    }
    public String getSize(){
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getArticle() {
        return article;
    }
    public void setArticle(String article) {
        this.article = article;
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }


}
