package pizza;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double doughModifier = 0.00;
        double bakingTechniqueModifier = 0.00;
        if(this.flourType.equals("White")){
            doughModifier = 1.50;
        } else {
            doughModifier = 1.0;
        } if (this.bakingTechnique.equals("Crispy")){
            bakingTechniqueModifier = 0.90;
        } else if (this.bakingTechnique.equals("Chewy")){
            bakingTechniqueModifier = 1.10;
        } else {
            bakingTechniqueModifier = 1.0;
        }
        return this.weight * 2 * bakingTechniqueModifier * doughModifier;
    }
}

