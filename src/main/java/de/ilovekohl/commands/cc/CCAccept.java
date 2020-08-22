package de.ilovekohl.commands.cc;


import com.google.gson.Gson;
import de.ilovekohl.main.Main;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.*;
import java.util.ArrayList;
import java.util.SplittableRandom;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class CCAccept implements MessageCreateListener {
    public static String name = "hatze";
    private Object JSONObject;

    private Gson gson = new Gson();



    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (Main.Wartung == false) {
            if (event.getMessage().getContent().equalsIgnoreCase(Main.p + "accept")) {
                if (Main.Wartung == false) {
                    if (event.getMessageAuthor().canDeleteMessage()) {
                        Message message = event.getMessage();


                        message.delete();

                        if (event.getMessageAuthor().getIdAsString().equalsIgnoreCase("227139282685394954")) {
                            name = "hatze";
                        } else if (event.getMessageAuthor().getIdAsString().equalsIgnoreCase("221731936878460928")) {
                            name = "quadra";
                        } else if (event.getMessageAuthor().getIdAsString().equalsIgnoreCase("447285957004099584")) {
                            name = "lukas";
                        } else if (event.getMessageAuthor().getIdAsString().equalsIgnoreCase("330711014977044482")) {
                            name = "sasukey";
                        } else if (event.getMessageAuthor().getIdAsString().equalsIgnoreCase("466986428107063306")) {
                            name = "iven";
                        } else if (event.getMessageAuthor().getIdAsString().equalsIgnoreCase("374639426875424772")) {
                            name = "kev";
                        }else if (event.getMessageAuthor().getIdAsString().equalsIgnoreCase("637943613581426708")) {
                            name = "annete";
                        }

                        event.getChannel().asServerTextChannel().get().updateName("n-carcreator-" + name);

                    }
                } else {

                }
            }
        }

    }
}
