package com.mechempire.agent;

import com.mechempire.sdk.core.game.AbstractMech;
import com.mechempire.sdk.core.game.AbstractTeam;
import com.mechempire.sdk.core.game.IMechControlFlow;
import com.mechempire.sdk.core.message.IProducer;
import com.mechempire.sdk.runtime.CommandMessage;

import java.util.Random;

/**
 * package: com.mechempire.agent
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/14 下午2:22
 * <p>
 * agent 主类
 */
public class AgentMain implements IMechControlFlow {

    private CommandMessage commandMessage;

    @Override
    public void run(IProducer producer, AbstractTeam team) {
        AbstractMech mainMech = team.getMechList().get(0);
        commandMessage = new CommandMessage();
        commandMessage.setTeamId(2);

        while (true) {
//            System.out.printf("I'm %s, vehicle_id: %d, weapon_id: %d, ammunition_id: %d, time: %d\n",
//                    team.getTeamName(), mainMech.getVehicle().getId(), mainMech.getWeapon().getId(), mainMech.getAmmunition().getId(),
//                    System.currentTimeMillis()
//            );
            commandMessage.clearByteSeq();
            Random random = new Random();
            int target = random.ints(100, 800).findFirst().getAsInt();
            commandMessage.appendByteSeq(mainMech.getVehicle().forward(target, target));
            producer.product(commandMessage);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}