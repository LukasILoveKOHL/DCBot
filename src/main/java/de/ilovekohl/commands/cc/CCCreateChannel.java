package de.ilovekohl.commands.cc;

import de.ilovekohl.main.Main;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.permission.PermissionState;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

import java.awt.*;
import java.security.Permission;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class CCCreateChannel implements ReactionAddListener {

    public static int id = 1;
    static Permissions fromBitmask(int allowedBitmask, int deniedBitmask) {
        PermissionsBuilder permissionsBuilder = new PermissionsBuilder();

        for (PermissionType permissionType : PermissionType.values()) {
            if (permissionType.isSet(allowedBitmask) && permissionType.isSet(deniedBitmask)) {
                permissionsBuilder.setState(permissionType, PermissionState.UNSET);
            } else if (permissionType.isSet(allowedBitmask)) {
                permissionsBuilder.setState(permissionType, PermissionState.ALLOWED);
            } else if (permissionType.isSet(deniedBitmask)) {
                permissionsBuilder.setState(permissionType, PermissionState.DENIED);
            } else {
                permissionsBuilder.setState(permissionType, PermissionState.UNSET);
            }
        }

        return permissionsBuilder.build();
    }

    PermissionsBuilder permissionsBuilder = new PermissionsBuilder();
    public static String ccrole = "733265124051124314";
    public static String everyone = "649168682362208256";
    public static String channel = "738720732430991400";
    public static ArrayList<String> user = new ArrayList<>();


    @Override
    public void onReactionAdd(ReactionAddEvent event) {
        if (event.getChannel().getIdAsString().equalsIgnoreCase(channel)) {
            if (!user.contains(String.valueOf(event.getUser().getId()))) {
                id++;
                CompletableFuture<ServerTextChannel> channel = null;
                try {
                    channel = new ServerTextChannelBuilder(Main.api.getServerById("649168682362208256").get())
                            .setTopic("donicar-" + id)
                            .setName("donicar-" + id)
                            .setAuditLogReason("donicar")
                            .addPermissionOverwrite(event.getUser(), fromBitmask(117824, 0))
                            .addPermissionOverwrite(Main.api.getRoleById(ccrole).get(), fromBitmask(117824, 0))
                            .addPermissionOverwrite(Main.api.getRoleById(everyone).get(), fromBitmask(0, -1))
                            .addPermissionOverwrite(Main.api.getUserById("726758951672348763").get(), fromBitmask(117824, 0))
                            .addPermissionOverwrite(Main.api.getRoleById("737265363452166185").get(), fromBitmask(2147483639,0))
                            .create();
                    user.add(String.valueOf(event.getUser().getId()));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                try {
                    channel.get().sendMessage(event.getUser().getMentionTag() + event.getApi().getRoleById(ccrole).get().getMentionTag());
                    EmbedBuilder embedBuilder = new EmbedBuilder()
                            .setTitle("**Doni-Car**")
                            .setThumbnail("https://i.imgur.com/Q1GqtW2.png")
                            .setDescription("Willkommen " + event.getUser().getMentionTag() + " \n" +
                                    "Ein " + event.getApi().getRoleById(ccrole).get().getMentionTag() + " wurde bereits bescheid gegeben, bitte suche dir auf dieser Website nun ein Auto aus: https://de.gta5-mods.com/vehicles")
                            .setFooter("* BigCityLifeRP *\n~ By IloveKOHL ~")
                            .setColor(Color.MAGENTA);
                    channel.get().sendMessage(embedBuilder);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }else {

            }
        }
    }
}
