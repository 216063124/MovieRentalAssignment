package za.ac.cput.factory;

import za.ac.cput.entity.Role;

import java.util.UUID;
/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

public class RoleFactory {

    public static Role build(int roleId , String name , String description)
    {
        if (name.isEmpty()||description.isEmpty()|| roleId < 0 )
        {
            return null;
        }

        int roleID = Integer.parseInt(UUID.randomUUID().toString());

        return new Role.roleBuilder()
                .setDescription(description).setRoleId(roleID).setName(name).build();
    }
}
