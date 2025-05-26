package org.acme;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Command(name = "greeting", mixinStandardHelpOptions = true)
public class GreetingCommand implements Runnable {

    @Parameters(paramLabel = "<name>", defaultValue = "picocli2",
        description = "Your name.")
    String name;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Locale locale = new Locale("pt", "BR");
            DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.LONG, locale);
            System.out.printf(String.format("%s : %s", dateFormat.format(new Date()), String.format("Hello %s, go go commando!\n", name)));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
