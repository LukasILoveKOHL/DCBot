package de.ilovekohl.main;

import de.ilovekohl.commands.cc.CCAccept;
import de.ilovekohl.commands.cc.CCCreateChannel;
import de.ilovekohl.commands.cc.CCDelete;
import de.ilovekohl.commands.cc.CCPayed;
import de.ilovekohl.listeners.*;


/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class EventCommandManager {


    public static void Listeners() {
        if (Main.Wartung == false) {
            Main.api.addListener(new CCAccept());
            Main.api.addListener(new CCPayed());
            Main.api.addListener(new StreamerListener());
            Main.api.addListener(new CCDelete());
            Main.api.addListener(new CCCreateChannel());
            Main.api.addListener(new StreamerClear());
            Main.api.addListener(new Logger());
            Main.api.addListener(new Hilfe());

        }
    }

}
