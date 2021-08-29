package pojo;

public class ProductsData {

    private String productName;
    private String imageURL;
    private String dollarPrice;
    private String poundPrice;
    private String euroPrice;

    public ProductsData(String productName, String imageURL, String dollarPrice, String poundPrice, String euroPrice) {
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

    public String getDollarPrice() {
        return dollarPrice;
    }

    public void setDollarPrice(String dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    public String getPoundPrice() {
        return poundPrice;
    }

    public void setPoundPrice(String poundPrice) {
        this.poundPrice = poundPrice;
    }

    public String getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(String euroPrice) {
        this.euroPrice = euroPrice;
    }


}