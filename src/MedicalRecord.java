
public class MedicalRecord {
    private String recordId;
    private boolean hasInsurance;
    private double price;
    private String discount;
    private String notes;



    public MedicalRecord(String recordId, double price) {
        this.recordId = recordId;
        this.price = price;
    }


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }


    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
        calculateDiscount();
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <0){
            System.out.println("ERROR:PRICE CANNOT BE NEGATIVE");
        }else{
            this.price = price;
            calculateDiscount();
        }

    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public String getDiscount() {
        return discount;
    }


    private void calculateDiscount() {
        if (hasInsurance) {
            this.discount = "yes";
            this.price *= 0.3;
        } else {
            this.discount = "no";
        }
    }

    @Override
    public String toString() {
        return "ID: " + recordId +
                "\nPrice: " + price +
                "\nHas Insurance: " + hasInsurance +
                "\nDiscount applied: " + discount +
                "\nNotes: " + notes;
    }
}