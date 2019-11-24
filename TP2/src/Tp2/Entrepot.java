package Tp2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Entrepot extends ArrayList<Objet> {
    Entrepot(){super();}
    public Entrepot getByName(LinkedList<String> strings ){
        Entrepot retval = new Entrepot();
        for(Objet o : this){
            for (String s : strings){
                if(o.getName().equals(s)) retval.add(o);
            }
        }
        return retval;
    }
    public Entrepot getByID(LinkedList<String> strings ){
        Entrepot retval = new Entrepot();
        for(Objet o : this){
            for (String s : strings){
                if(o.getID().toString().equals(s)) retval.add(o);
            }
        }
        return retval;
    }
    public Entrepot getByType(LinkedList<String> strings ){
        Entrepot retval = new Entrepot();
        for(Objet o : this){
            for (String s : strings){
                if(o.getType().asChar() == s.charAt(0)) retval.add(o);
            }
        }
        return retval;
    }


}