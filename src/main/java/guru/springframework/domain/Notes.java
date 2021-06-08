package guru.springframework.domain;

import javax.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    // no cascading needed since when you delete the notes the recipe does not need to be deleted, but
    // when you delete a recipe, its notes need to be deleted as well
    private Recipe recipe;
    @Lob
    //So in this case by default a String in Java can be very large, a lot larger than the default of
    //hibernate and JPA which is going to be 255 characters. So we want to allow our users to put in a
    // lot more than 250 characters or 255 characters on the Notes field. So what we are going to do to
    // use the Lob annotation.
    private String recipNotes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipNotes() {
        return recipNotes;
    }

    public void setRecipNotes(String recipNotes) {
        this.recipNotes = recipNotes;
    }


}
