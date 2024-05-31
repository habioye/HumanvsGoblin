import javax.swing.*;
public class Goblin {
    public int currentHP;
    public static int maxHP;
    public static int attack;
    public static int def;
    public int gold;
    protected ImageIcon icon;
    public Goblin(){
        maxHP = (int)(Math.random()*4)+20;
        currentHP = maxHP;
        attack = 7;
        def = 2;
        icon = new ImageIcon("HumanvsGoblin/src/main/java/assets/pngtree-goblin-cartoon-png-image_4008070.jpeg");  
    }
    public int getHealth(){
        return currentHP;
    }
    public int getMaxHealth(){
        return maxHP;
    }
    public int getGold(){
        return gold;
    }
    public void damageTaken(int damage){
        currentHP-=damage;
        if(currentHP<0){
            currentHP=0;
        }
    }
    public ImageIcon getIcon(){
        return icon;
    }
    public boolean isDead(){
        if(currentHP<=0){
            return true;
        }
        return false;
    }
    public int getDefense(){
        return (int)(Math.random() * 2) + def;
    }
    public int getAttack(){
        return (int)(Math.random() * 2) + attack;
    }
    public String inspect(){
        //System.out.println("Goblin:  "+"\nHP: "+currentHP+" / "+maxHP+"\n Attack: "+attack+" - " + (attack+1)+"\nDefense: "+def+" - "+(def+1));
        return "Goblin:  "+"\nHP: "+currentHP+" / "+maxHP+"\n Attack: "+attack+" - " + (attack+1)+"\nDefense: "+def+" - "+(def+1);
    }

}
