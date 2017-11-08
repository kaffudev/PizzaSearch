package pl.szymonkamil.models.services;

public class PizzaModel {

    private String adress;
    private double rating;
    private String name;

    public PizzaModel(String adress, double rating, String name) {
        this.adress = adress;
        this.rating = rating;
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PizzaModel{" +
                "adress='" + adress + '\'' +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                '}';
    }
}
