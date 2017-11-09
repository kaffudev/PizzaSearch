package pl.szymonkamil.models.services;

public class PizzaModel   {

    private String adress;
    private double rating;
    private String name;
    private String status;
    private int range;

    public PizzaModel(String adress, double rating, String name) {

        this.adress = adress;
        this.rating = rating;
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
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

    public String printPizza(){
        return "Nazwa lokalu: " + name + "\n" +
                "Adres lokalu: " + adress + "\n" +
                "Ocena lokalu (max 5) : " + rating;
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
