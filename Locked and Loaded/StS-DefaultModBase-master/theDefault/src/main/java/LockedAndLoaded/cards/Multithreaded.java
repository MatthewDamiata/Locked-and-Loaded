package LockedAndLoaded.cards;

import LockedAndLoaded.orbs.Awakening;
import com.megacrit.cardcrawl.actions.defect.AnimateOrbAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.defect.EvokeOrbAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.orbs.Plasma;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.powers.LockOnPower;
import com.megacrit.cardcrawl.localization.CardStrings;
import LockedAndLoaded.DefaultMod;

import static LockedAndLoaded.DefaultMod.makeCardPath;

public class Multithreaded extends AbstractDynamicCard {

    /*
     * Wiki-page: https://github.com/daviscook477/BaseMod/wiki/Custom-Cards
     *
     * Multithreaded Evoke your next orb. If any enemy has Lock-On, Channel two of the Orb that was Evoked.
     */

    // TEXT DECLARATION 

    public static final String ID = DefaultMod.makeID(Multithreaded.class.getSimpleName());
    public static final String IMG = makeCardPath("Skill.png");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    // /TEXT DECLARATION/

    // STAT DECLARATION 	

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.BLUE;

    private static final int COST = 1;

    private static final int AMOUNT = 2;
    private static final int UPGRADE_AMOUNT = 1;

    // /STAT DECLARATION/


    public Multithreaded() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseMagicNumber = magicNumber = AMOUNT;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        boolean foundLocked = false;
        for (final AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            if(mo.hasPower(LockOnPower.POWER_ID)){
                foundLocked = true;
                break;
            }
        }
        if(foundLocked){
            AbstractOrb orb = p.orbs.get(0);
            switch(orb.ID){
                case "Dark":
                    AbstractDungeon.actionManager.addToBottom(new AnimateOrbAction(1));
                    AbstractDungeon.actionManager.addToBottom(new EvokeOrbAction(1));
                    for(int i = 0; i < magicNumber; i++) {
                        AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Dark()));
                    }
                    break;
                case "Lightning":
                    AbstractDungeon.actionManager.addToBottom(new AnimateOrbAction(1));
                    AbstractDungeon.actionManager.addToBottom(new EvokeOrbAction(1));
                    for(int i = 0; i < magicNumber; i++) {
                        AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
                    }
                    break;
                case "Frost":
                    AbstractDungeon.actionManager.addToBottom(new AnimateOrbAction(1));
                    AbstractDungeon.actionManager.addToBottom(new EvokeOrbAction(1));
                    for(int i = 0; i < magicNumber; i++) {
                        AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Frost()));
                    }
                    break;
                case "Plasma":
                    AbstractDungeon.actionManager.addToBottom(new AnimateOrbAction(1));
                    AbstractDungeon.actionManager.addToBottom(new EvokeOrbAction(1));
                    for(int i = 0; i < magicNumber; i++) {
                        AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Plasma()));
                    }
                case "LockedAndLoaded:Awakening":
                    AbstractDungeon.actionManager.addToBottom(new AnimateOrbAction(1));
                    AbstractDungeon.actionManager.addToBottom(new EvokeOrbAction(1));
                    for(int i = 0; i < magicNumber; i++) {
                        AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Awakening()));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_AMOUNT);
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}