package de.ilovekohl.core;


import de.ilovekohl.main.Main;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.user.UserChangeActivityEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class permsCore {

    public static boolean check(UserChangeActivityEvent event) {
        Server server = null;
        List<Role> roles = server.getRoles(event.getUser());
        for (Role r : event.getUser().getRoles((Server) roles)) {

            if (Arrays.stream(de.ilovekohl.core.STATIC.PERMS).parallel().anyMatch(r.getName()::equalsIgnoreCase))
                return false;
            else
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }


        }
        return true;
    }

}
