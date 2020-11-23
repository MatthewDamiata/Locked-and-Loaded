package LockedAndLoaded.patches;

import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.blue.LockOn;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.LockOnPower;

import java.lang.reflect.Field;

import static javax.swing.UIManager.getInt;

public class LockOnPowerP{

        @SpirePatch(clz = com.megacrit.cardcrawl.orbs.AbstractOrb.class, method = "applyLockOn")
        public static class LockOnPatch_Power {
                public static int Postfix(AbstractCreature target, int damage) {
                        if (AbstractDungeon.player.hasRelic("LockedAndLoaded:MaleficShard") && target.hasPower("Lockon")) {
                                return (int) (damage * 1.75F);
                        } else if (target.hasPower("Lockon")) {
                                return (int) (damage * 1.5F);
                        } else {
                                return damage;
                        }
                }
        }

}