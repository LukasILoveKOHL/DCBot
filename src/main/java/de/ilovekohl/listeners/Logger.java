package de.ilovekohl.listeners;

import de.ilovekohl.main.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class Logger implements MessageCreateListener {
    /**
     * This method is called every time a message is created.
     *
     * @param event The event.
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().startsWith("_")) {
            EmbedBuilder embedBuilder = new EmbedBuilder()
                    .setTitle("**Log**")
                    .setThumbnail("https://i.imgur.com/Q1GqtW2.png")
                    .setDescription("Spieler: " + event.getMessageAuthor().getDisplayName() + "\n" +
                            "ID: " + event.getMessageAuthor().getId() + "\n" +
                            "Command: " + event.getMessageContent() + "\n" +
                            "JumpURL: " + event.getMessageLink())
                    .setFooter("* BigCityLifeRP *\n~ By IloveKOHL ~")
                    .setColor(Color.CYAN);
            Main.api.getTextChannelById("737236641109901392").get().sendMessage(embedBuilder);
        }
    }
}

