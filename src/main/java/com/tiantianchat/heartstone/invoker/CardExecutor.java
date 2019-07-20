package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Minion;
import com.tiantianchat.heartstone.model.dto.Profession;
import com.tiantianchat.heartstone.model.dto.Spell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardExecutor {

    @Autowired
    private SpellInvoker si;

    @Autowired
    private MinionCommander mc;

    // 不需要指定目标的卡牌
    public void exec(Profession src, Card card) {
        if (card instanceof Minion) {
            mc.sendMinion(src, (Minion)card);
        } else if (card instanceof Spell) {
            si.invoke(src, ((Spell)card).getName());
        }
    }

    // 需要指定一个目标的卡牌
    public void exec(Profession src, Card card, GameCharacter tar) {
        if (card instanceof Minion) {
            mc.sendMinion(src, (Minion)card, tar);
        } else if (card instanceof Spell) {
            si.invoke(src, ((Spell)card).getName(), tar);
        }
    }
}
