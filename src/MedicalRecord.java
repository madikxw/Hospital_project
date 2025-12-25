

public class MedicalRecord {
    private String recordId;
    private boolean has_Insurance;
    private double price;
    private String discount;
    private String notes;
    public MedicalRecord(String recordId,
                         double price){
        this.recordId = recordId;
        this.price = price;
    }
    public void setHas_Insurance(boolean has_Insurance){
        this.has_Insurance = has_Insurance;
    }
    public void set_notes(String notes){
        this.notes = notes;
    }
    public String getNotes(){
        return notes;
    }
    public void discount (){
        if(has_Insurance == true) {
            this.discount = "yes";
            this.price *=0.3;
        }else{
            this.discount = "no";
        }
    }
    public String toString(){
        return
                "ID: " + recordId  +
                        "\nprice: " + price +
                        "\nhas_Insurance: " + has_Insurance +
                        "\ndiscount: " + discount;

    }

}