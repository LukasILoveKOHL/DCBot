package de.ilovekohl.listeners;

import de.ilovekohl.main.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.user.UserChangeActivityEvent;
import org.javacord.api.listener.user.UserChangeActivityListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class StreamerListener implements UserChangeActivityListener {


    Server getServer() {
        Main.api.getServerById("").get();
        return null;
    }

    static String serverid = "649168682362208256";
    static String namerang = "Streamer";
    static String sendchannel = "725103693266944020";
    static String streamerb = "688732812458721300";

    public static ArrayList<String> nameid = new ArrayList<>();

    @Override
    public void onUserChangeActivity(UserChangeActivityEvent event) {
        String servera = String.valueOf(event.getUser().getRoles(Main.api.getServerById(serverid).get()));



        if (servera.contains(namerang)) {
            if (!nameid.contains(String.valueOf(event.getUser().getId()))) {
                nameid.add(String.valueOf(event.getUser().getId()));
                try {
                    if (event.getNewActivity().get() != null) {
                        if (event.getNewActivity().get().getType().name().equalsIgnoreCase("streaming")) {
                            EmbedBuilder embedBuilder = new EmbedBuilder()
                                    .setTitle("**Streamer-Info**")
                                    .setThumbnail("https://i.imgur.com/Q1GqtW2.png")
                                    .setDescription(event.getUser().getMentionTag() + " Streamt gerade! Checkt den Stream aus: " + event.getNewActivity().get().getStreamingUrl().get())
                                    .setFooter("* BigCityLifeRP *\n~ By IloveKOHL ~")
                                    .setColor(Color.MAGENTA);
                            Main.api.getTextChannelById(sendchannel).get().sendMessage(event.getApi().getUserById("637943613581426708").get().getMentionTag() + " ist ein Cooler Typ");
                            Main.api.getTextChannelById(sendchannel).get().sendMessage(embedBuilder);
                        }
                    }
                }catch (Exception e){

                }

            }
        }
    }
}
