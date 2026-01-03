package com.mk.javase.design.creational.factory;

import java.util.*;

// Abstract class representing cuisine
abstract class Cuisine {
    protected String dish;
    public Cuisine(String dish) {
        this.dish = dish;
    }
    public String getDish() {
        return dish;
    }
}

// Exception for unsupported cuisine
class UnservableCuisineRequestException extends Exception {
    public UnservableCuisineRequestException(String message) {
        super(message);
    }
}

// Cuisine Implementations
class ChineseCuisine extends Cuisine {
    public ChineseCuisine(String dish) {
        super(dish);
    }
}

class ItalianCuisine extends Cuisine {
    public ItalianCuisine(String dish) {
        super(dish);
    }
}

class JapaneseCuisine extends Cuisine {
    public JapaneseCuisine(String dish) {
        super(dish);
    }
}

class MexicanCuisine extends Cuisine {
    public MexicanCuisine(String dish) {
        super(dish);
    }
}

// Factory class
class FoodFactory {
    private static final Map<String, FoodFactory> cuisineRegistry = new HashMap<>();

    public static void registerCuisine(String name, FoodFactory factory) {
        cuisineRegistry.put(name, factory);
    }

    public static Cuisine serveCuisine(String cuisine, String dish) throws UnservableCuisineRequestException {
        FoodFactory factory = cuisineRegistry.get(cuisine);
        if (factory == null) {
            throw new UnservableCuisineRequestException("Cannot serve " + cuisine);
        }
        return factory.createCuisine(dish);
    }

    protected Cuisine createCuisine(String dish) {
        // Default implementation
        return null;
    }
}

// Specific Cuisine Factories
class Chinese extends FoodFactory {
    @Override
    protected Cuisine createCuisine(String dish) {
        return new ChineseCuisine(dish);
    }
}

class Italian extends FoodFactory {
    @Override
    protected Cuisine createCuisine(String dish) {
        return new ItalianCuisine(dish);
    }
}

class Japanese extends FoodFactory {
    @Override
    protected Cuisine createCuisine(String dish) {
        return new JapaneseCuisine(dish);
    }
}

class Mexican extends FoodFactory {
    @Override
    protected Cuisine createCuisine(String dish) {
        return new MexicanCuisine(dish);
    }
}

// Main class
public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);

    static {
        FoodFactory.registerCuisine("Chinese", new Chinese());
        FoodFactory.registerCuisine("Italian", new Italian());
        FoodFactory.registerCuisine("Japanese", new Japanese());
        FoodFactory.registerCuisine("Mexican", new Mexican());
    }

    public static void main(String[] args) {
        int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
        while (totalNumberOfOrders-- > 0) {
            String[] food = INPUT_READER.nextLine().split(" ");
            String cuisine = food[0];
            String dish = food[1];

            try {
                Cuisine servedFood = FoodFactory.serveCuisine(cuisine, dish);
                System.out.println("Serving " + servedFood.getDish() + "(" + cuisine + ")");
            } catch (UnservableCuisineRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
