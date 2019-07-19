package com.tiantianchat.test;

import com.tiantianchat.heartstone.skill.SkillInvoker;
import com.tiantianchat.heartstone.skill.SpellInvoker;
import com.tiantianchat.model.heartstone.dto.Profession;
import com.tiantianchat.repository.MinionRepository;
import com.tiantianchat.repository.ProfessionRepository;
import com.tiantianchat.repository.WeaponRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Wangyl
 * @date 2019/7/10
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


    @Test
    public void testLuckyCoin() {
        Profession shaman = pr.findByName("萨满").toDTO();
        spellInvoker.invoke(shaman, "luckyCoin");

        assert shaman.getCurCrystal() == 1;

        spellInvoker.invoke(shaman, "luckyCoin");
        spellInvoker.invoke(shaman, "luckyCoin");
        spellInvoker.invoke(shaman, "luckyCoin");


        assert shaman.getCurCrystal() == 4;
    }

    @Test
    public void testFireBall() {
        Profession zie = pr.findByName("潜行者").toDTO();
        Profession fashi = pr.findByName("法师").toDTO();

        zie.setCrystal(6);

        spellInvoker.invoke(zie, "fireBall", fashi);

        assert zie.getCurCrystal() == 2;
        assert fashi.getCurBlood() == 24;
    }

    @Test
    public void test() {

    }
}
