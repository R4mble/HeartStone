package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.exception.CardNotFoundException;
import com.tiantianchat.heartstone.exception.WrongTargetException;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Profession;
import com.tiantianchat.heartstone.model.dto.Spell;
import com.tiantianchat.repository.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * 法术释放器
 */
@Component
public class SpellInvoker {

    @Autowired
    private SpellRepository sr;

    public void invoke(Profession src, Spell spell, @Nullable GameCharacter tar)  {

        if (src.getCurCrystal() < spell.getCost()) {
            throw new ManaLessException();
        }

        if (!src.getHandCard().contains(spell)) {
            throw new CardNotFoundException();
        }

        String desc = spell.getDesc();

        if (desc.startsWith("addCurCrystal")) {
            src.setCurCrystal(src.getCurCrystal() +
                    Integer.parseInt(desc.substring("addCurCrystal".length())));
        } else if (desc.startsWith("hurtMinion")) {
            if (tar instanceof Profession) {
                throw new WrongTargetException();
            }
            Com.causeDamage(tar, Integer.parseInt(desc.substring("hurtMinion".length())));
        } else if (desc.startsWith("hurt")) {
            Com.causeDamage(tar, Integer.parseInt(desc.substring("hurt".length())));
        }

        src.getHandCard().remove(spell);
        src.setCurCrystal(src.getCurCrystal() - spell.getCost());
    }
}
