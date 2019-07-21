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
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CardExecutor {

    @Autowired
    private SpellInvoker spellInvoker;

    @Autowired
    private MinionCommander minionCommander;

    public void exec(Profession src, Card card, @Nullable GameCharacter tar) {
        if (card instanceof Minion) {
            minionCommander.send(src, (Minion)card, tar);
        } else if (card instanceof Spell) {
            spellInvoker.invoke(src, (Spell)card, tar);
        }
    }
}
