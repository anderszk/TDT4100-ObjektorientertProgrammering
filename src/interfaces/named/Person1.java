package interfaces.named;

public class Person1 implements Named{

    private String givenName;
    private String familyName;

    public Person1(String givenName, String familyName){
        this.familyName = familyName;
        this.givenName = givenName;
    }

    public void setFullName(String name) {
        this.givenName = name.substring(0, name.indexOf(" "));
        this.familyName = name.substring(name.indexOf(" ")+1);
    }

    public void setGivenName(String name) {
        this.givenName = name;
    }

    public void setFamilyName(String name) {
        this.familyName = name;
    }

    public String getFullName() {
        return this.givenName+" "+this.familyName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getGivenName() {
        return this.givenName;
    }

}
