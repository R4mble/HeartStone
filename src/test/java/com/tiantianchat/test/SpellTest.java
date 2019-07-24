package com.tiantianchat.test;

import com.tiantianchat.heartstone.invoker.SkillInvoker;
import com.tiantianchat.heartstone.invoker.SpellInvoker;
import com.tiantianchat.heartstone.model.dto.Profession;
import com.tiantianchat.heartstone.model.dto.Spell;
import com.tiantianchat.repository.MinionRepository;
import com.tiantianchat.repository.ProfessionRepository;
import com.tiantianchat.repository.SpellRepository;
import com.tiantianchat.repository.WeaponRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpellTest {

    @Autowired
    private SkillInvoker skillInvoker;

    @Autowired
    private SpellInvoker spellInvoker;

    @Autowired
    private ProfessionRepository pr;

    @Autowired
    private MinionRepository mr;

    @Autowired
    private WeaponRepository wr;

    @Autowired
    private SpellRepository sr;


    @Test
    public void testLuckyCoin() {
        Profession shaman = pr.findByName("萨满").toDTO();

        Spell luckyCoin = sr.findByName("luckyCoin").toDTO();

        spellInvoker.invoke(shaman, luckyCoin, null);

        assert shaman.getCurCrystal() == 1;

        spellInvoker.invoke(shaman, luckyCoin, null);
        spellInvoker.invoke(shaman, luckyCoin, null);
        spellInvoker.invoke(shaman, luckyCoin, null);

        assert shaman.getCurCrystal() == 4;
    }

    @Test
    public void testFireBall() {
        Profession zie = pr.findByName("潜行者").toDTO();
        Profession fashi = pr.findByName("法师").toDTO();

        Spell fireBall = sr.findByName("fireBall").toDTO();

        zie.setCrystal(6);

        spellInvoker.invoke(zie, fireBall, fashi);

        assert zie.getCurCrystal() == 2;
        assert fashi.getCurBlood() == 24;
    }

    @Test
    public void test() {


    }


}
