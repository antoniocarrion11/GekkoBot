//package org.bot.riot.model.match;
//
//public class MatchData {
//    public Metadata metadata;
//    public Players players;
//    public List<Round> rounds;
//    public List<Kill> kills;
//}
//
//public class AbilityCasts {
//    public int grenade;
//    public int ability1;
//    public int ability2;
//    public int ultimate;
//}
//
//public class MatchPlayerData {
//    public String puuid;
//    public String name;
//    public String tag;
//    public String team;
//    public int level;
//    public String character;
//    public int currenttier;
//    public String currenttier_patched;
//    public String player_card;
//    public String player_title;
//    public String party_id;
//    public AbilityCasts ability_casts;
//    public Stats stats;
//    public OverallEconomy economy;
//    public int damage_made;
//    public int damage_received;
//}
//
//public class PlayerStat {
//    public AbilityCasts ability_casts;
//    public String player_puuid;
//    public String player_display_name;
//    public String player_team;
//    public int damage;
//    public int bodyshots;
//    public int headshots;
//    public int legshots;
//    public List<Kill> kill_events;
//    public int kills;
//    public int score;
//    public RoundEconomy economy;
//}
//
//public class ValorantAsset {
//    public String id;
//    public String name;
//}
//
//public class QuickPlayer {
//    public String puuid;
//    public String display_name;
//    public String team;
//}
//
//public class DefuseEvents {
//    public QuickPlayer defused_by;
//    public int defuse_time_in_round;
//}
//
//
//public class OverallEconomy {
//    public EconomyValue spent;
//    public EconomyValue loadout_value;
//}
//
//public class RoundEconomy {
//    public int spent;
//    public int loadout_value;
//    public ValorantAsset weapon;
//    public ValorantAsset armor;
//    public int remaining;
//}
//
//public class Kill {
//    public int kill_time_in_round;
//    public int kill_time_in_match;
//    public String killer_puuid;
//    public String killer_display_name;
//    public String killer_team;
//    public String victim_puuid;
//    public String victim_display_name;
//    public String victim_team;
//    public String damage_weapon_id;
//    public String damage_weapon_name;
//    public boolean secondary_fire_mode;
//    public List<QuickPlayer> assistants;
//}
//
//
//public class Metadata {
//    public String map;
//    public String game_version;
//    public int game_length;
//    public int game_start;
//    public String game_start_patched;
//    public int rounds_played;
//    public String mode;
//    public String mode_id;
//    public String queue;
//    public String season_id;
//    public String matchid;
//}
//
//public class PlantEvents {
//    public QuickPlayer planted_by;
//    public String plant_site;
//    public int plant_time_in_round;
//}
//
//public class Players {
//    public List<MatchPlayerData> all_players;
//}
//
//public class Round {
//    public String winning_team;
//    public String end_type;
//    public boolean bomb_planted;
//    public boolean bomb_defused;
//    public PlantEvents plant_events;
//    public DefuseEvents defuse_events;
//    public List<PlayerStat> player_stats;
//}
//
//public class EconomyValue {
//    public int overall;
//    public int average;
//}
//
//public class Stats {
//    public int score;
//    public int kills;
//    public int deaths;
//    public int assists;
//    public int bodyshots;
//    public int headshots;
//    public int legshots;
//}
//
//
