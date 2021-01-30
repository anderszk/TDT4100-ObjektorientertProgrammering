package interfaces.named;

public class Person2 implements Named{
    private String fullName;

    public Person2(String fullName){
        this.fullName = fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public void setGivenName(String name) {
        this.fullName = name+" "+this.fullName.split(" ")[1];
    }

    public void setFamilyName(String name) {
        this.fullName = this.fullName.split(" ")[0]+" "+name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getFamilyName() {
        return this.fullName.split(" ")[1];
    }

    public String getGivenName() {
        return this.fullName.split(" ")[0];
    }
}
