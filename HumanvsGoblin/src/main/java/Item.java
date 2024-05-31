
public class Item {
	public enum ItemID {
		GOLD, SWORD
	}

	private int hp;
	private int attack;
	private double hit_rate;
	private String name;
	private ItemID itemId;
	private boolean equiped = true;

	public Item() {
		this.hp = 0;
		this.attack = 0;
		this.hit_rate = 0;
		this.name = "";
		this.itemId = ItemID.SWORD;
		this.equiped = false;
	}
	public Item(int attack, String name, ItemID itemID){
		this.hp = 0;
		this.attack = attack;
		this.hit_rate = 0;
		this.name = name;
		this.itemId = itemID;
		this.equiped = false;

	}
	public void setEquiped(boolean equiped){
		this.equiped = true;
	}
	public boolean getEquiped(){
		return this.equiped;
	}
	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public double getHit_rate() {
		return this.hit_rate;
	}

	public void setHit_rate(double hit_rate) {
		this.hit_rate = hit_rate;
	}

	public String getName() {
		return this.name;
	}

	public ItemID getItemId() {
		return this.itemId;
	}

	public void setItemId(ItemID itemId) {
		this.itemId = itemId;
	}

	public void setName(String name) {
		this.name = name;
	}

}
