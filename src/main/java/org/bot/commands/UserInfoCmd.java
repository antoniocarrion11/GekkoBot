package org.bot.commands;

import ca.tristan.easycommands.commands.EventData;
import ca.tristan.easycommands.commands.slash.SlashExecutor;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.bot.riot.api.ValorantController;
import org.bot.riot.model.AbstractResponse;
import org.bot.riot.model.player.PlayerData;
import org.bot.riot.model.player.PlayerResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserInfoCmd extends SlashExecutor {

    @Override
    public String getName() {
        return "user";
    }

    @Override
    public String getDescription() {
        return "assigns the user info to your discord with a [name] [riotTag]";
    }

    public List<OptionData> getOptions() {
        options.add(new OptionData(OptionType.STRING, "playername", "The valorant name of the user you're finding", true));
        options.add(new OptionData(OptionType.STRING, "tag", "The valorant tag of the user you're finding", true));
        return options;
    }

    /*
     * Execute takes whatever message was sent from the user to handle the call for userInfo
     *
     * IMPORTANT: The way event.reply works is it gives you an immediate reply to the interaction
     * say you want to delay the response (because of api calls/DB queries whatever)
     * event.deferReply delays up to  15mins,
     * you then send the later reply with event.gethook().sendMessage({content})
     * moreover, if you want to have multiple replies you HAVE to use .deferReply
     * */
    @Override
    public void execute(EventData event) {

        List<OptionMapping> commandOptions = event.getCommand().getOptions();

        if (commandOptions.isEmpty() || commandOptions.size() < 2) {
            event.getEvent().reply("You gotta gimme a name and a tag bro!").setEphemeral(true).queue();
            return;
        }

        event.deferReply();
        String name = commandOptions.get(0).getAsString();
        String tag = commandOptions.get(1).getAsString();

        String responseString = getResponseString(name, tag);

        event.getHook().sendMessage(responseString).queue();
    }

    private static @NotNull String getResponseString(String name, String tag) {
        String responseString;
        ValorantController controller = new ValorantController();

        // TODO: Wrap this call in a try catch block
        //  Catch the exception and cast the abstract response into an error
        //  then return the response string from the error's data
        AbstractResponse response = controller.getUser(name, tag);
        PlayerResponse playerResponse = (PlayerResponse) response;
        PlayerData playerData = playerResponse.getResponseData();
        responseString =
                "Ay dawg! Here's the guy you were looking for: \n"
                        + "Userid: "
                        + playerData.getPuuid()
                        + "\n"
                        + "Name and Tag: "
                        + playerData.getName()
                        + "#"
                        + playerData.getTag()
                        + "\n"
                        + "Level: "
                        + playerData.getAccount_level();

        return responseString;
    }
}
