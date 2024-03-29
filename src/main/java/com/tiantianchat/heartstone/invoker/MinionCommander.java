package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.constant.Consts;
import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.exception.CardNotFoundException;
import com.tiantianchat.heartstone.exception.SceneFullException;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Minion;
import com.tiantianchat.heartstone.model.dto.Profession;
import com.tiantianchat.repository.MinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * 随从派遣器
 */
@Component
public class MinionCommander {

    @Autowired
    private MinionRepository mr;

    public void send(Profession src, Minion minion, @Nullable GameCharacter tar) {

        if (src.getCurCrystal() < minion.getCost()) {
            throw new ManaLessException();
        }

        if (!src.getHandCard().contains(minion)) {
            throw new CardNotFoundException();
        }

        if (src.getScene().size() >= Consts.MAX_SCENE) {
            throw new SceneFullException();
        }

        if (minion.getBattleCry() != null) {
            if (minion.getBattleCry().startsWith("hurt")) {
                Com.causeDamage(tar, Integer.parseInt(minion.getBattleCry().substring(4)));
            }
            if (minion.getBattleCry().startsWith("heal")) {
                Com.heal(tar, Integer.parseInt(minion.getBattleCry().substring(4)));
            }
        }

        src.getHandCard().remove(minion);
        src.getScene().add(minion);
        src.setCurCrystal(src.getCurCrystal() - minion.getCost());
    }
}
