package LockedAndLoaded.potions;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GameDictionary;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.helpers.TipHelper;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.powers.LockOnPower;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class LiquidMetal extends AbstractPotion {


    public static final String POTION_ID = LockedAndLoaded.DefaultMod.makeID("LiquidMetal");
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);
    
    public static final String NAME = potionStrings.NAME;
    public static final String[] DESCRIPTIONS = potionStrings.DESCRIPTIONS;

    public LiquidMetal() {
        // The bottle shape and inside is determined by potion size and color. The actual colors are the main DefaultMod.java
        super(NAME, POTION_ID, PotionRarity.COMMON, PotionSize.M, PotionColor.SMOKE);
        
        // Potency is the damage/magic number equivalent of potions.
        isThrown = true;
        targetRequired = true;
    }

    @Override
    public void initializeData(){
        potency = getPotency();

        // Initialize the Description
        description = DESCRIPTIONS[0] + potency + DESCRIPTIONS[1];

        // Do you throw this potion at an enemy or do you just consume it.

        // Initialize the on-hover name + description
        tips.clear();
        tips.add(new PowerTip(name, description));
        this.tips.add(new PowerTip(

                TipHelper.capitalize(GameDictionary.LOCK_ON.NAMES[0]), (String)GameDictionary.keywords
                .get(GameDictionary.LOCK_ON.NAMES[0])));
    }

    @Override
    public void use(AbstractCreature target) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(target, AbstractDungeon.player, new LockOnPower(target, potency)));
    }
    
    @Override
    public AbstractPotion makeCopy() {
        return new LiquidMetal();
    }

    // This is your potency.
    @Override
    public int getPotency(final int potency) {
        return 5;
    }

}
