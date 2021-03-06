package pl.cwanix.opensun.model.character;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.model.account.AccountModel;

import java.time.LocalDateTime;

@Getter
@Setter
public class CharacterModel {

    private int id;
    private AccountModel account;
    private int classCode;
    private int heightCode;
    private int faceCode;
    private int hairCode;
    private int level;
    private int strength;
    private int dexterity;
    private int vitality;
    private int intelligence;
    private int spirit;
    private int skillStat1;
    private int skillStat2;
    private int userPoint;
    private long experience;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int remainStat;
    private int remainSkill;
    private int selectedStyle;
    private int pkState;
    private int charState;
    private int stateTime;
    private int slot;
    private CharacterPositionModel position;
    private int titleId;
    private int invisibleOpt;
    private InventoryModel inventory;
    private byte[] skill;
    private byte[] quick;
    private byte[] style;
    private byte[] quest;
    private byte[] mission;
    private int playLimitedTime;
    // private int pvpPoint;
    // private int pvpScore;
    // private int pvpGrade;
    // private int pvpDraw;
    // private int pvpSeries;
    // private int pvpKill;
    // private int pvpDie;
    // private int pvpMaxKill;
    // private int pvpMaxDie;
    // private GuildEntity guild;
    // private int guildPosition;
    // private int guildUserPoint;
    private String name;
    // private String guildNickName;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private LocalDateTime lastLoginDate;
    private boolean deleted;
}
