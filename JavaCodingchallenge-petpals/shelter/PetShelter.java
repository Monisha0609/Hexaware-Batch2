package shelter;

import entity.Pet;
import java.util.ArrayList;
import java.util.List;

public class PetShelter {
    private List<Pet> availablePets = new ArrayList<>();

    public void addPet(Pet pet) {
        availablePets.add(pet);
        System.out.println("Pet added to shelter: " + pet.getName());
    
    }

    public void removePet(Pet pet) {
        availablePets.remove(pet);
    }

    public void listAvailablePets() {
        for (Pet pet : availablePets) {
            try {
                if (pet.getName() == null || pet.getAge() <= 0) {
                    throw new NullPointerException("Missing pet information.");
                }
                System.out.println(pet);
            } catch (NullPointerException e) {
                System.out.println("Pet data error: " + e.getMessage());
            }
        }
    }
}

