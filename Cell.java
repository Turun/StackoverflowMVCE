import java.util.*; 
import java.awt.*;

public class Cell
{
    public static final int[] nationalColors = {
        Color.RED.getRGB() | 0xff000000,
        Color.BLACK.getRGB() | 0xff000000
    };
    
    private final Grid grid;
    
    private final int x;
    private final int y;
    private ArrayList<Person> inhabs;
    
    public Cell(Grid g, int x, int y, ArrayList<Person> inh){
        grid = g;
        this.x = x;
        this.y = y;
        if(inh == null){
            inhabs = new ArrayList<Person>();
        }else{
            inhabs = inh;
        }
    }
    
    /**
     * tells every person in this cell to make a step
     */
    public void tick(){
        int peopleSum = inhabs.size();
        for(Person p : inhabs.toArray(new Person[inhabs.size()])){
            p.tick();
        }
    }
    
    public void moveMe(Person p){
        try{
            Cell northOfHere = grid.grid[y-1][x];
            northOfHere.add(p);
        }catch(ArrayIndexOutOfBoundsException ex){System.out.println("fell from edge");/*person falls from the edge of the world*/}
        
        System.out.println("removed: " + inhabs.remove(p));
    }
    
    public int getSumInhabs(){
        if(inhabs.size() > 10000){
            System.out.println("over population and they can't even reproduce: " + x + " - " + y+ " - " + inhabs.size());
        }
        return inhabs.size();
    }
    
    public void add(Person p){
        inhabs.add(p);
    }
}
