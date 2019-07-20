package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Minion;
import com.tiantianchat.heartstone.model.dto.Profession;
import com.tiantianchat.heartstone.model.dto.Spell;
import com.tiantianchat.repository.MinionRepository;
import com.tiantianchat.repository.SpellRepository;
import com.tiantianchat.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardExecutor {

    @Autowired
    private SpellInvoker si;

    @Autowired
    private MinionCommander mc;

    @Autowired
    private MinionRepository mr;

    @Autowired
    private SpellRepository sr;

    @Autowired
    private WeaponRepository wr;

    // 不需要指定目标的卡牌
    public void exec(Profession src, String cardName) {
        if (mr.findByName(cardName) != null) {
            mc.sendMinion(src, cardName);
        } else if (sr.findByName(cardName) != null) {
            si.invoke(src, cardName);
        }
    }

    // 需要指定一个目标的卡牌
    public void exec(Profession src, String cardName, GameCharacter tar) {
        if (mr.findByName(cardName) != null) {
            mc.sendMinion(src, cardName, tar);
        } else if (sr.findByName(cardName) != null) {
            si.invoke(src, cardName, tar);
        }
    }
}
