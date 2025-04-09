package donation;

public class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, String itemType) {
        super(donorName, 0);
        this.itemType = itemType;
    }

    @Override
    public void recordDonation() {
        System.out.println("Item donation by " + getDonorName() + " of type: " + itemType);
    }
}
