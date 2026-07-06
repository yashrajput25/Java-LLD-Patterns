package Creational_Design_Patterns;

class Product{

    private String id;
    private double price;

    private String description, category;
    private double discount;
    private boolean inStock;

    public Product(ProductBuilder builder) {
        this.id = builder.id;
        this.price = builder.price;
        this.description = builder.description;
        this.category = builder.category;
        this.discount = builder.discount;
        this.inStock = builder.inStock;
    }

    public void display() {
        System.out.println("----- Product Details -----");
        System.out.println("ID          : " + id);
        System.out.println("Price       : " + price);
        System.out.println("Description : " + description);
        System.out.println("Category    : " + category);
        System.out.println("Discount    : " + discount + "%");
        System.out.println("In Stock    : " + (inStock ? "Yes" : "No"));
    }

    public static class ProductBuilder{

        private String id;
        private double price;
        private String description, category;
        private double discount;
        private boolean inStock;

        public ProductBuilder(String id, double price){
            this.id = id;
            this.price = price;
        }

        public ProductBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public ProductBuilder setInStock(boolean inStock) {
            this.inStock = inStock;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }

}

public class builderPattern2 {

    public static void main(String[] args){

        Product product = new Product.ProductBuilder("1", 10000)
                .setDiscount(10)
                .setInStock(true)
                .build();

        product.display();

    }
}
