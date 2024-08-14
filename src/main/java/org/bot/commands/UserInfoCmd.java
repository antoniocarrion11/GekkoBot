package org.bot.commands;

import ca.tristan.easycommands.commands.EventData;
import ca.tristan.easycommands.commands.slash.SlashExecutor;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.bot.riot.api.ValorantController;
import org.bot.riot.model.AbstractResponse;
import org.bot.riot.model.error.ErrorResponse;
import org.bot.riot.model.player.PlayerResponse;

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


    @Override
    public void execute(EventData data) {

        if (data.getCommand().getOptions().isEmpty()) {
            data.getEvent().reply("You gotta gimme a name and a tag bro!").setEphemeral(true).queue();
            return;
        }

        String name = data.getCommand().getOptions().get(0).getAsString();
        String tag = data.getCommand().getOptions().get(1).getAsString();

        ValorantController controller = new ValorantController();
        AbstractResponse response = controller.getUser(name, tag);

        // TODO: Instead of checking the errors array check the status
        if (!response.getAllErrors().isEmpty()) {
            ErrorResponse errorResponse = (ErrorResponse) response;
        } else {
            PlayerResponse playerResponse = (PlayerResponse) response;
            data.reply("Ay dawg! Here's the guy you were looking for:", false).queue();
            data.reply("Userid: " + playerResponse.getResponseData().getPuuid(), false).queue();
            data.reply("Name: " + playerResponse.getResponseData().getName(), false).queue();
            data.reply("Tag: " + playerResponse.getResponseData().getTag(), false).queue();
            data.reply("Level: " + playerResponse.getResponseData().getAccountLevel(), false).queue();
        }
    }
}
