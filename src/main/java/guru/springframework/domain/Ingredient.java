package guru.springframework.domain;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitofMeasurement unitofMeasurement;

// This defines the inverse relation, we are using the ManyToOne annotation to say that it goes back to a
//recipe and we are not using any cascade there because we don't want to have any type of delete operation
//  cascade back to the parent object which is recipe. This is a bi-directional relationship,which means
// you can access ingredients from recipe and  recipe from ingredients.
    @ManyToOne
    private Recipe recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitofMeasurement getUnitofMeasurement() {
        return unitofMeasurement;
    }

    public void setUnitofMeasurement(UnitofMeasurement unitofMeasurement) {
        this.unitofMeasurement = unitofMeasurement;
    }




}
