package de.ilovekohl.listeners;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class StreamerClear implements MessageCreateListener {
    /**
     * This method is called every time a message is created.
     *
     * @param event The event.
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getChannel().getIdAsString().equalsIgnoreCase("666234784670023680")){
            if (event.getMessageContent().equalsIgnoreCase("15")){
                StreamerListener.nameid.clear();
            }
        }
    }
}
