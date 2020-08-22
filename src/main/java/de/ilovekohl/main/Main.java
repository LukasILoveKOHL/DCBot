package de.ilovekohl.main;

import de.ilovekohl.commands.Wartungen;
import de.ilovekohl.commands.cc.CCAccept;
import de.ilovekohl.commands.cc.CCCreateChannel;
import de.ilovekohl.commands.cc.CCDelete;
import de.ilovekohl.commands.cc.CCPayed;
import de.ilovekohl.listeners.*;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class Main {



    static String token = "NzI2NzU4OTUxNjcyMzQ4NzYz.Xvh9BA.YkPvY23yMGDXH4jrMXuk4yeGzKI";
    public static DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

    public static String p = "_";


    public static boolean Wartung = false;


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        api.addListener(new Wartungen());

        if (Wartung == false) {

            EventCommandManager.Listeners();
            //  api.addListener(new CCReaction());

            api.addMessageCreateListener(event -> {
                if (event.getMessageAuthor().canUseTtsInTextChannel()) {
                    if (event.getMessageContent().equalsIgnoreCase(Main.p + "cchelp")) {
                        event.getMessage().delete();
                        Optional<ServerTextChannel> channel = event.getChannel().asServerTextChannel();
                        EmbedBuilder builder = new EmbedBuilder()
                                .setFooter("• BigCityLifeRP \n" +
                                        "~ By IloveKOHL ~")
                                .setColor(Color.ORANGE)
                                .setTitle("**CC-Help**")
                                .setDescription("Alle Commands die ihr braucht: \n" +
                                        "-ccdelete (L" + "\u00f6" + "scht den jeweiligen Channel in den ihr seit)\n" +
                                        "-accept (um einen Auftrag anzunehmen)\n" +
                                        "-payed (wenn der Auftrag bezahlt ist)");
                        channel.get().sendMessage(builder);

                    }
                }

            });
        }
        shutdown();

        //api.getTextChannelById("737236641109901392").get().sendMessage("`JavaCord ONLINE`");




    }

    public static void shutdown() {
        new Thread(() -> {
            String line = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                while ((line = reader.readLine()) != null) {

                    if (line.equalsIgnoreCase("stop") || line.equalsIgnoreCase("exit")) {

                        if (api != null) {
                            api.unsetActivity();
                            api.disconnect();
                            System.out.println("Bot offline.");

                        }

                        reader.close();
                        break;
                    }
                }
            } catch (Exception e) {

            }

        }).start();
    }


}

