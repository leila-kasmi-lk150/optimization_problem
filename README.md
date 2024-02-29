# Optimization Problem Solver

This repository contains Java implementations of a classic optimization problems

## Optimization Problems

### Traveling Salesman Problem (TSP)

The TSP involves finding the shortest possible route that visits a set of cities and returns to the starting city. 

#### TSP Algorithms

- **Greedy Algorithm :**
  - A heuristic approach to find a near-optimal solution for TSP by choosing the locally optimal solution at each step.

- **Random Search for :**
  - An exploration-based approach that generates random solutions and iteratively improves them to find a solution.
    
### Knapsack Problem 

In the Knapsack Problem implementation, a randomized approach is employed to explore potential solutions efficiently. 
The algorithm initializes a knapsack with randomly selected objects (represented by 0 or 1), 
and in each iteration, it modifies the state of the knapsack by toggling the presence of a randomly selected object.

### Methodology for Knapsack Problem

1. **Initialization:**
   - The knapsack is initialized with a random set of objects, where 1 represents the inclusion of an object, and 0 represents exclusion.

2. **Random Modification:**
   - At each iteration, a random object in the knapsack is chosen.
   - The chosen object's inclusion/exclusion status is toggled (from 0 to 1 or vice versa).

3. **Evaluation:**
   - After each modification, the solution's fitness is evaluated based on the total value of included objects and the constraint of the knapsack size.

4. **Acceptance Criteria:**
   - The modified solution is accepted if it satisfies the knapsack size constraint and improves the overall objective value.




