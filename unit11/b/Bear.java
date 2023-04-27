package unit11.b;

// let's explore inheritance!
public class Bear {
    private Zoo whereILive;
    private String name;
    public Bear;
}

public String void main(String[] args){
    //Panda meiLan = new Panda("Mei Lan");
    Bear mrBear = new Bear();
    Panda mrPandaBear = new Panda();
}

// https://wwf.panda.org/wwf_news/?163461/Is-the-giant-panda-a-bear
class Panda extends Bear {
    public Panda(String pandaName){
        super(pandaName);
        this.name = pandaName;
    }    
    
}

// https://en.wikipedia.org/wiki/List_of_giant_pandas
class Zoo {
    private Panda inhabitant;
}

// Zookeeper, Visitor, etc.
