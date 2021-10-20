package za.ac.cput.factory;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRental;
import java.util.UUID;

public class UserRentalFactory {

    public static UserRental build(int userId, int movieId, String rentalDate, String returnDate, String rentedBy){

        if (userId<0 || movieId<0 || rentalDate.isEmpty() || returnDate.isEmpty() || rentedBy.isEmpty()){
            return null;
        }

        String id= UUID.randomUUID().toString();

        return new UserRental.UserRentalBuilder()
                .setRentalId(id).setUserId(userId).setMovieId(movieId).setRentalDate(rentalDate).setReturnDate(returnDate).setRentedBy(rentedBy).build();
    }

}
