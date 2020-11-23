package LockedAndLoaded.relics;


import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import LockedAndLoaded.DefaultMod;
import LockedAndLoaded.util.TextureLoader;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LockOnPower;


import static LockedAndLoaded.DefaultMod.makeRelicOutlinePath;
import static LockedAndLoaded.DefaultMod.makeRelicPath;

public class Threadripper extends CustomRelic {
    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     *
     * Threadripper At the start of each combat, apply 1 Lock-On to ALL enemies.
     */

    // ID, images, text.
    public static final String ID = DefaultMod.makeID("Threadripper");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("placeholder_relic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic.png"));

    public Threadripper() {
        super(ID, IMG, OUTLINE, RelicTier.COMMON, LandingSound.CLINK);
    }
    @Override
    public void atBattleStart() {
        flash();
        for (final AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, AbstractDungeon.player,
                    new LockOnPower(mo, 1), 1));
        }
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
