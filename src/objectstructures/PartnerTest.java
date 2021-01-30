package objectstructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PartnerTest {

    private Partner p1;
    private Partner p2;

    @BeforeEach
    public void setup() {
        p1 = new Partner("1");
        p2 = new Partner("2");
    }

    @Test
    public void testConstructor() {
        Assertions.assertNull(p1.getPartner());
        Assertions.assertNull(p2.getPartner());
    }

    @Test
    public void simplePartnerShip() {
        // Enkelt partnerskap
        Assertions.assertNull(p1.getPartner());
        Assertions.assertNull(p2.getPartner());
        p1.setPartner(p2);
        Assertions.assertEquals(p1.getPartner(), p2);
        Assertions.assertEquals(p2.getPartner(), p1);
    }

    @Test
    public void partnershipWithDivorce() {
        // Partnerskap med etterfølgende brudd
        p1.setPartner(p2);
        Assertions.assertEquals(p1.getPartner(), p2);
        Assertions.assertEquals(p2.getPartner(), p1);
        p1.setPartner(null);
        Assertions.assertNull(p1.getPartner());
        Assertions.assertNull(p2.getPartner());
    }

    @Test
    void swinger() {
        //"Partnerskap med etterfølgende kombinert brudd og nytt partnerskap"
        Partner p3 = new Partner("3");
        Partner p4 = new Partner("4");
        // Partnerskap inngås
        p1.setPartner(p2);
        p3.setPartner(p4);
        Assertions.assertEquals(p1.getPartner(), p2);
        Assertions.assertEquals(p2.getPartner(), p1);
        Assertions.assertEquals(p3.getPartner(), p4);
        Assertions.assertEquals(p4.getPartner(), p3);
        // Kombinert brudd og nytt partnerskap
        p1.setPartner(p4);
        Assertions.assertEquals(p1.getPartner(), p4);
        Assertions.assertEquals(p4.getPartner(), p1);
        Assertions.assertNull(p2.getPartner());
        Assertions.assertNull(p3.getPartner());
    }
}
