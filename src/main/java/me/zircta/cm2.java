package me.zircta;

import net.weavemc.loader.api.command.Command;
import org.jetbrains.annotations.NotNull;

public class cm2 extends Command {
    public cm2() {
        super("test", "test");
    }

    @Override
    public void handle(@NotNull String[] strings) {
        System.out.println("ravenb1 command");
        w.f2();
    }
}

