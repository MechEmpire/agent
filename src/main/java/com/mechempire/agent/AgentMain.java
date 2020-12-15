package com.mechempire.agent;

import com.mechempire.agent.mech.DefaultMech;
import com.mechempire.sdk.core.factory.MechFactory;
import com.mechempire.sdk.core.game.IMechControlFlow;
import com.mechempire.sdk.core.message.IProducer;
import com.mechempire.sdk.runtime.CommandMessage;

/**
 * package: com.mechempire.agent
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/14 下午2:22
 * <p>
 * agent 主类
 */
public class AgentMain implements IMechControlFlow {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private CommandMessage commandMessage;

    @Override
    public void run(IProducer producer) {
        DefaultMech mainMech = new DefaultMech();
        MechFactory.assemblyMech(mainMech);
        commandMessage = new CommandMessage();
        commandMessage.setTeamId(2);

        while (true) {
            // 指令帧
            System.out.printf(ANSI_RED + "I'm red, vehicle_id: %d, weapon_id: %d, ammunition_id: %d, time: %d\n",
                    mainMech.getVehicleId(), mainMech.getWeaponId(), mainMech.getAmmunitionId(), System.currentTimeMillis());
            commandMessage.cleanCommandSeq();
            commandMessage.appendCommandSeq(mainMech.getVehicle().forward());
            producer.product(commandMessage);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}