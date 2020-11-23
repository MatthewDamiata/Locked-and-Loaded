package LockedAndLoaded.patches;

import LockedAndLoaded.orbs.Awakening;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.*;

import java.util.ArrayList;

public class RandomOrbP {

        @SpirePatch(clz = com.megacrit.cardcrawl.orbs.AbstractOrb.class, method = "getRandomOrb")
        public static class RandomOrbPatch {
                public static AbstractOrb Replace(boolean useCardRng){
                        ArrayList<AbstractOrb> orbs = new ArrayList<>();
                        orbs.add(new Dark());
                        orbs.add(new Frost());
                        orbs.add(new Lightning());
                        orbs.add(new Plasma());
                        orbs.add(new Awakening());
                        if (useCardRng)
                                return orbs.get(AbstractDungeon.cardRandomRng.random(orbs.size() - 1));
                        return orbs.get(MathUtils.random(orbs.size() - 1));
                }
        }

}