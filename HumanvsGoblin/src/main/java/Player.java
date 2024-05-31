
import java.util.ArrayList;

public class Player {
    public int attackDamage;
    public ArrayList<Item> inventory;
    private int currWeapon = -1;

    public int getWeapon(){
        return this.currWeapon;
    }
    public void setWeapon(int currWeapon){
        this.currWeapon = currWeapon;
    }


}
