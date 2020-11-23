package LockedAndLoaded.cards;

import LockedAndLoaded.orbs.Awakening;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import LockedAndLoaded.DefaultMod;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.powers.LockOnPower;

import static LockedAndLoaded.DefaultMod.makeCardPath;

public class Firewall extends AbstractDynamicCard {

    /*
     * Wiki-page: https://github.com/daviscook477/BaseMod/wiki/Custom-Cards
     *
     * Firewall If the enemy intends to attack, apply 2(3) Lock-On and Channel 1 Awakening.
     */

    // TEXT DECLARATION 

    public static final String ID = DefaultMod.makeID(Firewall.class.getSimpleName());
    public static final String IMG = makeCardPath("Skill.png");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/


    // STAT DECLARATION 	

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.BLUE;

    private static final int COST = 1;
    private static final int AMT = 2;
    private static final int UPGRADE_AMT = 1;
    // /STAT DECLARATION/


    public Firewall() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseMagicNumber = magicNumber = AMT;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(m.intent.equals(AbstractMonster.Intent.ATTACK)) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, m, new LockOnPower(m, magicNumber)));
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Awakening()));
        }
    }

    //Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_AMT);
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}