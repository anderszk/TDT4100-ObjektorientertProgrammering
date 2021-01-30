package interfaces.named;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Person2Test{

    private String h, t;
    private Person2 person2;

    @BeforeEach
    public void setup() {
        h = "Hallvard"; t = "Trætteberg";
        person2 = new Person2(h + " " + t);
    }

    @Test
    public void testConstructor() {
        Assertions.assertEquals(h, person2.getGivenName());
        Assertions.assertEquals(t, person2.getFamilyName());
        Assertions.assertEquals(h+" "+t, person2.getFullName());
    }

    @Test
    public void testSetGivenName() {
        String j = "Jens";
        person2.setGivenName(j);
        Assertions.assertEquals(j, person2.getGivenName());
        Assertions.assertEquals(t, person2.getFamilyName());
        Assertions.assertEquals(j+" "+t, person2.getFullName());
    }

    @Test
    public void testSetFamilyName() {
        String o = "Olsen";
        person2.setFamilyName(o);;
        Assertions.assertEquals(h, person2.getGivenName());
        Assertions.assertEquals(o, person2.getFamilyName());
        Assertions.assertEquals(h+" "+o, person2.getFullName());
    }

    @Test
    public void testSetFullName() {
        String l = "Lisa"; String e = "Eriksen";
        String fullName = l + " " + e;
        person2.setFullName(fullName);
        Assertions.assertEquals(l, person2.getGivenName());
        Assertions.assertEquals(e, person2.getFamilyName());
        Assertions.assertEquals(fullName, person2.getFullName());
    }
}
