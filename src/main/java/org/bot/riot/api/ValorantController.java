package org.bot.riot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValorantController {

    @GetMapping("/greeting")
    public String get() {
        return "Ayo! I'm Gekkobot your guy in the chair!";
    }

}
