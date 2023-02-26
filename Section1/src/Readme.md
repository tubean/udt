Q: A logistic company plan to rent a large amount of empty container. Your task is to design an algorithm to help logistic company able to rent enough containers (the highest priority) at the lowest price.
Suppose: 
1. price is integer, > 0
2. Amount of container provider < 100

A:
1. Find all combinations of container provider: using back-track algorithm
2. Filter combinations which have enough containers
3. Sort these combinations by sum of prices
4. Choose the combination which has the lowest price
