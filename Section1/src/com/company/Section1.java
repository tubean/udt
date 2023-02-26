package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Section1 {
    public static void main(String[] args) {
        // Test Case 1
        int neededContainer = 12;
        List<ContainerProvider> listings = new ArrayList<>();
        listings.add(new ContainerProvider("Container renter A", 5, 5));
        listings.add(new ContainerProvider("Container renter B", 4, 2));
        listings.add(new ContainerProvider("Container renter D", 6, 3));
        listings.add(new ContainerProvider("Container renter C", 11, 11));
        listings.add(new ContainerProvider("Container renter E", 2, 1));

        if (neededContainer <= 0) {
            System.out.println("You don't need to rent anything!");
            return;
        }
        // find an effective strategy to rent
        List<ContainerProvider> renters = findEffectiveRenter(neededContainer, listings);
        // print the result
        if (renters.isEmpty()) {
            printResult(listings, false);
        } else {
            printResult(renters, true);
        }
    }

    /**
     * find an effective strategy to rent containers with the lowest price.
     * Using brute-force, recursion algorithm.
     * The space complexity is O(n * 2^n)
     * The time complexity is O(n * 2^n)
     *
     * @param neededContainer amount of containers need to be rent
     * @param listings        list of provides containers
     * @return list of provided containers to rent, return empty if there are not enough containers
     */
    public static List<ContainerProvider> findEffectiveRenter(int neededContainer, List<ContainerProvider> listings) {
        // build TreeSet which contains all combinations, the cost is priority
        TreeSet<List<ContainerProvider>> validCombinations = new TreeSet<>((c1, c2) -> {
            int cost1 = c1.stream().mapToInt(ContainerProvider::getContainerCost).sum();
            int cost2 = c2.stream().mapToInt(ContainerProvider::getContainerCost).sum();
            return Integer.compare(cost1, cost2);
        });

        int listingSize = listings.size();
        for (int i = 1; i <= listingSize; i++) {
            // find all list of combinations which has size = i
            List<List<ContainerProvider>> listsCombinations = findAllCombination(listings, i);
            // add valid combination
            for (List<ContainerProvider> combination : listsCombinations) {
                int sumContainers = combination.stream().mapToInt(ContainerProvider::getContainerAmount).sum();
                // only add to TreeSet combination which has enough containers
                if (sumContainers >= neededContainer) {
                    validCombinations.add(combination);
                }
            }
        }

        return validCombinations.first();
    }

    /**
     * generates all possible combinations of the elements in the input list using recursion
     * <p>
     * The time complexity is O(2^n * n) :the total number of function calls is 2^n, and for each function call,
     * the function needs to create a new sublist, which takes O(n) time.
     * The space complexity of the combinations function is also O(2^n * n).
     *
     * @param listings list of containers provider
     * @param i        size of subSet
     * @return all subsSet of listings with size is i
     */
    private static List<List<ContainerProvider>> findAllCombination(List<ContainerProvider> listings, int i) {
        List<List<ContainerProvider>> result = new ArrayList<>();
        // return empty list when i==0 or i > listSize
        if (i == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        int listSize = listings.size();
        if (i > listSize) {
            return result;
        }

        // all combinations = all combinations contains first item + all combinations not contains first item
        // all combinations not contains first item and has size = i
        List<List<ContainerProvider>> withoutFirst = findAllCombination(listings.subList(1, listSize), i);
        // all combinations not contains first item has size = i - 1 (will include first item later)
        List<List<ContainerProvider>> withFirst = findAllCombination(listings.subList(1, listSize), i - 1);

        // add first item to all combinations not contains first item
        for (List<ContainerProvider> sublist : withFirst) {
            sublist.add(0, listings.get(0));
        }
        result.addAll(withoutFirst);
        result.addAll(withFirst);
        return result;
    }

    /**
     * print the report
     *
     * @param listings          list of provides containers
     * @param isEnoughContainer flag to check enough containers to rent
     */
    private static void printResult(List<ContainerProvider> listings, boolean isEnoughContainer) {
        int totalCost = 0;
        for (ContainerProvider renter : listings) {
            System.out.println(renter.toString());
            totalCost += renter.getContainerCost();
        }
        System.out.print("[Summary] total cost " + totalCost);
        if (!isEnoughContainer) {
            System.out.println(", not enough containers");
        }
    }

    static class ContainerProvider {
        String name;
        int containerAmount; // suppose > 0
        int containerCost; // suppose > 0

        public ContainerProvider(String name, int containerAmount, int containerCost) {
            this.name = name;
            this.containerAmount = containerAmount;
            this.containerCost = containerCost;
        }

        public int getContainerAmount() {
            return containerAmount;
        }

        public int getContainerCost() {
            return containerCost;
        }

        @Override
        public String toString() {
            return "[Contact with] " + name + " " + containerAmount + " container, price: " + containerCost;
        }
    }
}

