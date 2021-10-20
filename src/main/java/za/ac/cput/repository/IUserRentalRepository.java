package za.ac.cput.repository;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRental;
import java.util.Set;
@Deprecated
public interface IUserRentalRepository extends IRepository<UserRental, String> {
    public Set<UserRental> getAll();
}
