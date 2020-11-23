package LockedAndLoaded.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.LockOnPower;

@SpirePatch(clz = com.megacrit.cardcrawl.powers.LockOnPower.class, method = "updateDescription")
public class LockOnDescP {
        public static void Replace(LockOnPower __instance){
            if (__instance.owner != null) {
                if (__instance.amount == 1 && AbstractDungeon.player.hasRelic("LockedAndLoaded:MaleficShard")) {
                    __instance.description = "Receives #b75% more damage from Orbs for #b" + __instance.amount + " turn.";
                } else if (__instance.amount != 1 && AbstractDungeon.player.hasRelic("LockedAndLoaded:MaleficShard")) {
                    __instance.description = "Receives #b75% more damage from Orbs for #b" + __instance.amount + " turns.";
                } else if (__instance.amount == 1) {
                    __instance.description = "Receives #b50% more damage from Orbs for #b" + __instance.amount + " turn.";
                } else {
                    __instance.description = "Receives #b50% more damage from Orbs for #b" + __instance.amount + " turns.";
                }
            }
        }
}
