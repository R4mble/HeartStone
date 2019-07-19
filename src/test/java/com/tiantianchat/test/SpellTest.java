package com.tiantianchat.test;

import com.tiantianchat.heartstone.skill.SkillInvoker;
import com.tiantianchat.model.heartstone.dto.Profession;
import com.tiantianchat.repository.MinionRepository;
import com.tiantianchat.repository.ProfessionRepository;
import com.tiantianchat.repository.WeaponRepository;
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
    private ProfessionRepository pr;

    @Autowired
    private MinionRepository mr;

    @Autowired
    private WeaponRepository wr;


    public void testLuckyCoin() {
        Profession shaman = pr.findByName("Shaman").toDTO();
        shaman.castSpell("luckyCoin");
        assert shaman.curCrystal == 1;

        shaman.castSpell("luckyCoin");
        shaman.castSpell("luckyCoin");
        shaman.castSpell("luckyCoin");

        assert shaman.curCrystal == 4;
    }
}
