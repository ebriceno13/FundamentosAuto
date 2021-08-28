package pojo;

public class Products {

    private String productName;
    private String imageURL;
    private double dollarPrice;
    private double poundPrice;
    private double euroPrice;

    public Products(String productName, String imageURL, double dollarPrice, double poundPrice, double euroPrice) {
        this.productName = productName;
        this.imageURL = imageURL;
        this.dollarPrice = dollarPrice;
        this.poundPrice = poundPrice;
        this.euroPrice = euroPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getDollarPrice() {
        return dollarPrice;
    }

    public void setDollarPrice(double dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    public double getPoundPrice() {
        return poundPrice;
    }

    public void setPoundPrice(double poundPrice) {
        this.poundPrice = poundPrice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        this.euroPrice = euroPrice;
    }


}