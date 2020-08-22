package de.ilovekohl.commands.cc;

import de.ilovekohl.main.Main;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class CCDelete implements MessageCreateListener {
    /**
     * This method is called every time a message is created.
     *
     * @param event The event.
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (Main.Wartung == false) {
            if (event.getMessageContent().equalsIgnoreCase(Main.p + "ccdelete") || event.getMessageContent().equalsIgnoreCase(Main.p + "delete")) {
                if (event.getMessageAuthor().canDeleteMessage() || event.getMessageAuthor().canBanUsersFromServer()) {
                    EmbedBuilder embedBuilder = new EmbedBuilder()
                            .setTitle("**Viel Spass mit dem Auto**")
                            .setThumbnail("https://i.imgur.com/Q1GqtW2.png")
                            .setDescription("Danke f" +"\u00fc"+"r die Spende &\n viel Spa\u00df auf dem Server!")
                            .setFooter("* BigCityLifeRP *\n~ By IloveKOHL ~")
                            .setColor(Color.MAGENTA);
                    Main.api.getTextChannelById(event.getChannel().getId()).get().sendMessage(embedBuilder);

                    try {
                        TimeUnit.SECONDS.sleep(3);
                        ServerTextChannel channel = (ServerTextChannel) event.getChannel();
                        channel.delete();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
