public class Player {
    public int currentHP;
    public static int maxHP;
    public static int attack;
    public static int def;
    public int gold;
    protected ImageIcon icon;
    public Player(){
        maxHP = (int)(Math.random()*6)+30;
        currentHP = maxHP;
        attack = 10;
        def = 3;
        icon = new ImageIcon("HumanvsGoblin/HumanvsGoblin/src/main/java/assets/human.jpeg");  
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
        return "Player:  "+"\nHP: "+currentHP+" / "+maxHP+"\n Attack: "+attack+" - " + (attack+1)+"\nDefense: "+def+" - "+(def+1);
    }

    public int getWeapon(){
        return this.currWeapon;
    }
    public void setWeapon(int currWeapon){
        this.currWeapon = currWeapon;
    }


}
