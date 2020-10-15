public interface Animal{
    public int age;
    public String gender;

    public void isMammal();
    public void mate();
}

public class Duck implements Animal{
    public String beakColor = "yellow";
    public void swim();
    public void quack();
    
    public bool isMammal(){
        return false;
    }
    public void mate(){
        do_mate_duck()
    }
}

public class Fish implements Animal{
    private int sizeInFt;
    private bool canEat; 

    private void swim();

    public bool isMammal(){
        return false;
    }
    public void mate(){
        do_mate_fish()
    }
}



public class Zebra implements Animal{
    public bool is_wild;

    public bool isMammal(){
        return true;
    }
    public void mate(){
        do_mate_zebra()
    }
    public void run();
}
}