public class Gold extends Item {
	private int amount;

	public Gold(int amount) {
		this.setName("Gold");
		this.setItemId(ItemID.GOLD);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void addAmount() {
		this.amount += amount;
	}

}
