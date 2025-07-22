package com.chefmanager.storage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("SALE")
public class SalesOrder extends Order{

//    @Column(columnDefinition = "TEXT")
//    private String productsString;

    @OneToMany(mappedBy = "salesOrder")
    private List<SalesOrderItem> salesOrderItems;

    private List<Product> productList;

    protected SalesOrder() {}

//    public SalesOrder(String productsString){this.setProductsString(productsString);}
//
//    public SalesOrder(List<Product> productList){ this.setProductsString(this.productListItensToString(productList));}

    /**
     * Obsolete
     * */
    private String productListItensToString(List<Product> productList){
        StringBuilder productCollection = new StringBuilder();
        int productCollectionSize = productList.size();

        productCollection.append("{\"products\": [");
        for(int i = 0; i  < productCollectionSize; i++){
            String recipes = productList.get(i).getRecipeCollection();
            String productRecipes = recipes.substring(1, recipes.length() - 1);
            productCollection.append("{\"id\": \"" + productList.get(i).getId() + "\", \"title\": \""+
                    productList.get(i).getTitle() + "\", \"description\": \"" +
                    productList.get(i).getDescription() + "\", " +
                    productRecipes + "}");
            if(i < productCollectionSize - 1){
                productCollection.append(",");
            }
        }
        productCollection.append("]}");

        return productCollection.toString();
    }

//    public String getProductsString() {
//        return productsString;
//    }
//
//    public void setProductsString(String productsString) {
//        this.productsString = productsString;
//    }

    public List<SalesOrderItem> getSalesOrderItems() {
        return salesOrderItems;
    }

    public void setSalesOrderItems(List<SalesOrderItem> salesOrderItems) {
        this.salesOrderItems = salesOrderItems;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
