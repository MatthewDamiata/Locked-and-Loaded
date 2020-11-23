package LockedAndLoaded.relics;


import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import LockedAndLoaded.DefaultMod;
import LockedAndLoaded.util.TextureLoader;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LockOnPower;


import static LockedAndLoaded.DefaultMod.makeRelicOutlinePath;
import static LockedAndLoaded.DefaultMod.makeRelicPath;

public class MaleficShard extends CustomRelic {
    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     *
     * Malefic Shard Enemies with Lock-On take 75% more damage rather than 50%.
     */

    // ID, images, text.
    public static final String ID = DefaultMod.makeID("MaleficShard");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("placeholder_relic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic.png"));

    public MaleficShard() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.SOLID);
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
