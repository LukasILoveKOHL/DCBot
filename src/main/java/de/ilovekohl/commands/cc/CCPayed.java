package de.ilovekohl.commands.cc;


import de.ilovekohl.main.Main;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class CCPayed implements MessageCreateListener {
    public static String name;
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (Main.Wartung == false) {
            if (event.getMessageAuthor().isUser()) {

                if (event.getMessageAuthor().canDeleteMessage() || event.getMessageAuthor().canBanUsersFromServer()) {
                    if (Main.Wartung == false) {
                        Message message = event.getMessage();
                        if (event.getMessage().getContent().equalsIgnoreCase(Main.p + "payed")) {
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

                            event.getChannel().asServerTextChannel().get().updateName("b-carcreator-" + name);

                        }
                    }
                } else {
                }
            }
        }
    }
}
