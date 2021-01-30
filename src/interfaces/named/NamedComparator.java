package interfaces.named;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {

    @Override
    public int compare(Named o1, Named o2) {
        if(!o1.getFamilyName().equals(o2.getFamilyName())){
            System.out.println(o1.getFamilyName().compareTo(o2.getFamilyName()));
            return o1.getFamilyName().compareTo(o2.getFamilyName());
        }
        else if (o1.getFamilyName().equals(o2.getFamilyName())){
            return o1.getGivenName().compareTo(o2.getGivenName());
        }
        else{
            return 0;
        }
    }
}
