public class Item {
	public enum ItemID {
		GOLD, SWORD
	}

	private int hp;
	private int attack;
	private double hit_rate;
	private String name;
	private ItemID itemId;

	public Item() {

	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public double getHit_rate() {
		return hit_rate;
	}

	public void setHit_rate(double hit_rate) {
		this.hit_rate = hit_rate;
	}

	public String getName() {
		return name;
	}

	public ItemID getItemId() {
		return itemId;
	}

	public void setItemId(ItemID itemId) {
		this.itemId = itemId;
	}

	public void setName(String name) {
		this.name = name;
	}

}
