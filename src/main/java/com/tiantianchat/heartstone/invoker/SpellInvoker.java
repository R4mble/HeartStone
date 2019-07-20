package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.exception.CardNotFoundException;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Profession;
import com.tiantianchat.heartstone.model.dto.Spell;
import com.tiantianchat.repository.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 法术释放器
 */
@Component
public class SpellInvoker {

    @Autowired
    private SpellRepository sr;


    // 不需要指定目标的法术
    public void invoke(Profession src, String spellName)  {

        Spell spell = sr.findByName(spellName).toDTO();

        if (src.getCurCrystal() < spell.getCost()) {
            throw new ManaLessException();
        }

        if (!src.getHandCard().contains(spell)) {
            throw new CardNotFoundException();
        }

        if (spell.getDesc().startsWith("addCurCrystal")) {
            src.setCurCrystal(src.getCurCrystal() + Integer.parseInt(spell.getDesc().substring("addCurCrystal".length())));
        }


        src.getHandCard().remove(spell);
        src.setCurCrystal(src.getCurCrystal() - spell.getCost());
    }

    // 需要指定一个目标的法术
    public void invoke(Profession src, String spellName, GameCharacter tar) {

    }
}
