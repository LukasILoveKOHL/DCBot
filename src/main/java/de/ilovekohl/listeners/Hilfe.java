package de.ilovekohl.listeners;

import de.ilovekohl.main.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import sun.nio.cs.UnicodeEncoder;
import sun.text.normalizer.UnicodeSet;

import java.awt.*;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class Hilfe implements MessageCreateListener {
    /**
     * This method is called every time a message is created.
     *
     * @param event The event.
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageAuthor().canUseTtsInTextChannel()){
            if (event.getMessageContent().equalsIgnoreCase(Main.p + "hilfe") || event.getMessageContent().equalsIgnoreCase(Main.p + "help") || event.getMessageContent().equalsIgnoreCase(Main.p + "info") || event.getMessageContent().equalsIgnoreCase(Main.p + "cmd")){
                EmbedBuilder embedBuilder = new EmbedBuilder()
                        .setTitle("**Hilfe**")
                        .setThumbnail("https://i.imgur.com/Q1GqtW2.png")
                        .setDescription("Commands:\n" +
                                "_accept (um ein Ticket anzunehmen)\n" +
                                "_payed (um das Ticket auf bezahlt zu setzen)\n" +
                                "_delete (um das ticket zu schließen)\n")
                        .setFooter("* BigCityLifeRP *\n~ By IloveKOHL ~")
                        .setColor(Color.CYAN);
                Main.api.getTextChannelById(event.getChannel().getId()).get().sendMessage(embedBuilder);
            }
        }
    }
}
