package donation;

import java.time.LocalDateTime;

public class CashDonation extends Donation {
    private LocalDateTime donationTime;

    public CashDonation(String donorName, double amount, LocalDateTime donationTime) {
        super(donorName, amount);
        this.donationTime = donationTime;
    }

    public LocalDateTime getDonationTime() {
        return donationTime;
    }

    @Override
    public void recordDonation() {
        System.out.println("Cash donation of Rs." + getAmount() + " by " + getDonorName() + " on " + donationTime);
    }
}


