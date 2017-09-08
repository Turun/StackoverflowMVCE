
public class Person extends Object
{
    private Cell cell;
    private int health;
    private int strength;
    private int food;
    private final int nation;
    
    public Person(Cell c){this(c, 200,100,50, 0);}
    public Person(Cell c, int h, int s, int f, int n){
        cell = c;
        health = h;
        strength = s;
        food = f;
        nation = n;
    }
    
    public void tick(){
        //for testing
        cell.moveMe(this);
    }
    
    public int getHealth(){return health;}
    public int getStrength(){return strength;}
    public int getFood(){return food;}
    public int getNation(){return nation;}
    
    public boolean equals(Object obj){
        System.out.print(toString() + " equals " + obj.toString()+ " --- ");
        if(obj == null){System.out.println("0"); return false;}
        if(obj == this){System.out.println("1"); return true;}
        if(!(obj instanceof Person)){System.out.println("2"); return false;}
        
        Person p = (Person)obj;
        if(p.getHealth()   != health)  {System.out.println("3"); return false;}
        if(p.getStrength() != strength){System.out.println("4"); return false;}
        if(p.getFood()     != food)    {System.out.println("5"); return false;}
        System.out.println("6"); 
        return true;
    }
    
    public int hashCode(){
        return toString().hashCode();
    }
    
    public String toString(){
        return String.format("Health: %03d, Strength: %03d, Food: %03d, Nation: %02d", health, strength, food, nation);
    }
}
