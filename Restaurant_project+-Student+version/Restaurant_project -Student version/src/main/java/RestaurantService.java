import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RestaurantService  {

    private static List<Restaurant> restaurants = new ArrayList<>();
    //restaurantNotFoundException restaurantNotFoundException;

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        List<Restaurant> restaurantList = restaurants.stream().filter(r -> r.getName().equals(restaurantName)).collect(Collectors.toList()) ;
        if(restaurantList.size()==0){
            throw new restaurantNotFoundException("Error: Restaurant could not be found");
        }
        return restaurantList.get(0);
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
