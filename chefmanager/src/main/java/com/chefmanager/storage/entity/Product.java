package com.chefmanager.storage.entity;

import com.chefmanager.common.datatransfer.ProductStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Transient
    private List<Recipe> recipes;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "product")
    private SalesOrderItem salesOrderItem;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String recipeCollection;

    @UpdateTimestamp
    private Instant updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    public Product(String title, String description, ProductStatus productStatus, Menu menu) {
        this.setTitle(title);
        this.setDescription(description);
        this.setProductStatus(productStatus);
        this.setRecipeCollection("empty");
        this.setMenu(menu);
    }

    public Product(String title, String description, List<Recipe> recipes, ProductStatus productStatus,  Menu menu){
        this.setTitle(title);
        this.setDescription(description);
        this.setRecipeCollection(this.recipeListItensToString(recipes));
        this.setProductStatus(productStatus);
        this.setMenu(menu);
    }

    public Product(String title, String description,  Menu menu){
        this.setTitle(title);
        this.setDescription(description);
        this.setRecipeCollection("empty");
        this.setProductStatus(ProductStatus.INACTIVE);
        this.setMenu(menu);
    }

    protected Product(){}

    private String recipeListItensToString(List<Recipe> recipes){
        StringBuilder recipeCollection = new StringBuilder();
        int recipesLength = recipes.size();

        recipeCollection.append("{ \"recipes\": [ ");

        for(int x = 0; x < recipesLength; x++){

            recipeCollection.append("{\"id\": \"" + recipes.get(x).getId() +  "\","+
                    "\"title\": \"" + recipes.get(x).getTitle()+ "\"");
            if(x < recipesLength - 1){
                recipeCollection.append(",");
            }
        }

        recipeCollection.append("]}");

        return recipeCollection.toString();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SalesOrderItem getSalesOrderItem() {
        return salesOrderItem;
    }

    public void setSalesOrderItem(SalesOrderItem salesOrderItem) {
        this.salesOrderItem = salesOrderItem;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String getRecipeCollection() {
        return recipeCollection;
    }

    public void setRecipeCollection(String recipeCollection) {
        this.recipeCollection = recipeCollection;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }
}
