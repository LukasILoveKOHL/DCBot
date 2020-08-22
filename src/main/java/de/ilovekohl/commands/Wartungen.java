package de.ilovekohl.commands;

import de.ilovekohl.main.Main;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class Wartungen implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageAuthor().canUseTtsInTextChannel()) {
            Message message = event.getMessage();
            if (message.getContent().equalsIgnoreCase(Main.p + "wartung")) {
                if (Main.Wartung == false) {
                    Main.Wartung = true;
                    event.getChannel().sendMessage("`Wartung sind nun an`");
                } else {
                    Main.Wartung = false;
                    event.getChannel().sendMessage("`Wartung sind nun aus`");
                }
                message.delete();
            }
        }
    }
}
