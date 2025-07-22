package com.chefmanager.storage.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@DiscriminatorValue("BUY")
public class BuyOrder extends Order{

//    @Column(columnDefinition = "TEXT")
//    private String ingredients;

    @OneToMany(mappedBy = "buyOrder")
    private List<BuyOrderItem> buyOrderItems;

    private List<Ingredient> ingredientList;

    protected BuyOrder() {

    }


//    public BuyOrder (String ingredients){
//        this.setIngredients(ingredients);
//    }
//
//    public BuyOrder (List<Ingredient> ingredientList){
//        this.setIngredients(this.ingredientListItensToString(ingredientList));
//    }


    /**
     * Obsolete
     * */
    private String ingredientListItensToString(List<Ingredient> ingredientList){
        StringBuilder ingredientCollection = new StringBuilder();
        int ingredientLength = ingredientList.size();

        ingredientCollection.append("{ \"ingredients\": [ ");

        for(int x = 0; x < ingredientLength; x++){

            ingredientCollection.append("{\"id\": \"" + ingredientList.get(x).getId() +  "\","+
                    "\"title\": \"" + ingredientList.get(x).getName()+ "\"");
            if(x < ingredientLength - 1){
                ingredientCollection.append(",");
            }
        }

        ingredientCollection.append("]}");

        return ingredientCollection.toString();
    }

//    public String getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(String ingredients) {
//        this.ingredients = ingredients;
//    }

    public List<BuyOrderItem> getBuyOrderItems() {
        return buyOrderItems;
    }

    public void setBuyOrderItems(List<BuyOrderItem> buyOrderItems) {
        this.buyOrderItems = buyOrderItems;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
