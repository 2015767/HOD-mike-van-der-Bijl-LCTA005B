package nl.hva.web.model;

public class ShoppingItem {

    private Product product;
    private int quantity;
    private float price;
    private String name;

    public ShoppingItem(Product product, int quantity, float price, String name) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public Product getProduct() {
        return product;
        }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }
     public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
