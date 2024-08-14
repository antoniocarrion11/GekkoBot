//package org.bot.riot.model.match;
//
//import org.bot.riot.model.player.PlayerResponse;
//import org.bot.riot.model.player.PlayerData;
//
//import java.util.List;
//
//public class TestPojo {
//
//    public class AbilityCasts {
//        public int grenade;
//        public int ability1;
//        public int ability2;
//        public int ultimate;
//    }
//
//    public class DamageEvent {
//        public QuickPlayer player;
//        public int bodyshots;
//        public int headshots;
//        public int legshots;
//        public int damage;
//    }
//
//    public class ValorantAsset {
//        public String id;
//        public String name;
//    }
//
//    public class QuickPlayer {
//        public String puuid;
//        public String display_name;
//        public String team;
//    }
//
//    public class Match {
//        public Metadata metadata;
//        public List<PlayerData> players;
//        public List<Team> teams;
//        public List<Round> rounds;
//        public List<Kill> kills;
//    }
//
//    public class RoundEconomy {
//        public int loadout_value;
//        public int remaining;
//        public ValorantAsset weapon;
//        public ValorantAsset armor;
//    }
//
//    public class Kill {
//        public int time_in_round_in_ms;
//        public int time_in_match_in_ms;
//        public int round;
//        public QuickPlayer killer;
//        public QuickPlayer victim;
//        public List<QuickPlayer> assistants;
//        public ValorantAsset weapon;
//        public boolean secondary_fire_mode;
//    }
//
//    public class Metadata {
//        public String match_id;
//        public ValorantAsset map;
//        public String game_version;
//        public String platform;
//        public String region;
//        public String cluster;
//    }
//
//    public class Plant {
//        public int round_time_in_ms;
//        public String site;
//        public PlayerResponse playerResponse;
//    }
//
//    public class Queue {
//        public String id;
//        public String name;
//        public String mode_type;
//    }
//
//    public class Root {
//        public int status;
//        public ArrayList<Datum> data;
//    }
//
//    public class Round {
//        public int id;
//        public String result;
//        public String ceremony;
//        public String winning_team;
//        public Plant plant;
//        public Object defuse;
//        public List<RoundStats> stats;
//    }
//
//    public class Season {
//        public String id;
//        public String short_;
//    }
//
//    public class RoundStats {
//        public QuickPlayer player;
//        public AbilityCasts ability_casts;
//        public List<DamageEvent> damage_events;
//        public DamageStats stats;
//        public RoundEconomy economy;
//    }
//
//    public class DamageStats {
//        public int score;
//        public int kills;
//        public int deaths;
//        public int assists;
//        public int bodyshots;
//        public int headshots;
//        public int legshots;
//    }
//
//    public class Results {
//        int won;
//        int loss;
//    }
//    public class Team{
//        public String team_id;
//        public Results rounds;
//        public boolean won;
//    }
//
//}
