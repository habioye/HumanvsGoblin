import java.awt.image.BufferedImage;

public class Item {
	public enum ItemID {
		GOLD, SWORD
	}

	public BufferedImage image;
	public int attack;
	public String name;
	public ItemID itemId;


	public Item() {
		this.attack = 0;
		this.name = "";
		this.itemId = ItemID.SWORD;

	}
	
	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
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