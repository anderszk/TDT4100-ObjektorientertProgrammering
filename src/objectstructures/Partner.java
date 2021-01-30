package objectstructures;

public class Partner {
    private String name;
    private Partner partner;

    public Partner(String name){
        this.name = name;
    }

    public String getName(Partner p){
        return p.name;
    }

    public Partner getPartner(){
        return this.partner;
    }

    public void setPartner(Partner person){
        Partner gammel = this.getPartner();
        if (this.partner != person) {

            if(gammel == null){
                this.partner = person;
                person.setPartner(this);
            }
            else if(person == null){
                this.partner = null;
                gammel.setPartner(null);
            }
            else{
                gammel.setPartner(null);
                setPartner(null);
                setPartner(person);
            }
        }
    }
}
