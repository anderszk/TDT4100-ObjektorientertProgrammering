package interfaces.named;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Person1Test{

    private String h, t;
    private Person1 person1;

    @BeforeEach
    public void setup() {
        h = "Hallvard"; t = "Trætteberg";
        person1 = new Person1(h, t);
    }

    @Test
    public void testConstructor() {
        Assertions.assertEquals(h, person1.getGivenName());
        Assertions.assertEquals(t, person1.getFamilyName());
        Assertions.assertEquals(h+" "+t, person1.getFullName());
    }

    @Test
    public void testSetGivenName() {
        String j = "Jens";
        person1.setGivenName(j);
        Assertions.assertEquals(j, person1.getGivenName());
        Assertions.assertEquals(t, person1.getFamilyName());
        Assertions.assertEquals(j+" "+t, person1.getFullName());
    }

    @Test
    public void testSetFamilyName() {
        String o = "Olsen";
        person1.setFamilyName(o);;
        Assertions.assertEquals(h, person1.getGivenName());
        Assertions.assertEquals(o, person1.getFamilyName());
        Assertions.assertEquals(h+" "+o, person1.getFullName());
    }

    @Test
    public void testSetFullName() {
        String l = "Lisa"; String e = "Eriksen";
        String fullName = l + " " + e;
        person1.setFullName(fullName);
        Assertions.assertEquals(l, person1.getGivenName());
        Assertions.assertEquals(e, person1.getFamilyName());
        Assertions.assertEquals(fullName, person1.getFullName());
    }
}
