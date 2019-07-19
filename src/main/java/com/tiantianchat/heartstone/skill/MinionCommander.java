package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.exception.MinionNotFoundException;
import com.tiantianchat.heartstone.exception.SceneFullException;
import com.tiantianchat.model.heartstone.GameCharacter;
import com.tiantianchat.model.heartstone.dto.Minion;
import com.tiantianchat.model.heartstone.dto.Profession;
import org.springframework.stereotype.Component;

/**
 * @author Ramble
 */
@Component
public class MinionCommander {


    public void sendMinion(Profession src, Minion minion) {
        if (src.getCurCrystal() < minion.getCost()) {
            throw new ManaLessException();
        }

        if (!src.getHandCard().contains(minion)) {
            throw new MinionNotFoundException();
        }

        if (src.getScene().size() >= 7) {
            throw new SceneFullException();
        }

        src.getHandCard().remove(minion);
        src.getScene().add(minion);
        src.setCurCrystal(src.getCurCrystal() - minion.getCost());
    }

    public void sendMinion(Profession src, Minion minion, GameCharacter tar) {
        if (src.getCurCrystal() < minion.getCost()) {
            throw new ManaLessException();
        }

        if (!src.getHandCard().contains(minion)) {
            throw new MinionNotFoundException();
        }

        if (src.getScene().size() >= 7) {
            throw new SceneFullException();
        }

        if (minion.getBattleCry() != null) {
            if (minion.getBattleCry().startsWith("hurt")) {
                Attack.causeDamage(tar, Integer.parseInt(minion.getBattleCry().substring(4)));
            }
        }

        src.getHandCard().remove(minion);
        src.getScene().add(minion);
        src.setCurCrystal(src.getCurCrystal() - minion.getCost());
    }
}
