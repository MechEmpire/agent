package com.mechempire.agent;

import com.mechempire.sdk.constant.EngineStatus;
import com.mechempire.sdk.constant.MechRunResult;
import com.mechempire.sdk.core.game.AbstractMech;
import com.mechempire.sdk.core.game.AbstractTeam;
import com.mechempire.sdk.core.game.IMechControlFlow;
import com.mechempire.sdk.core.message.IProducer;
import com.mechempire.sdk.runtime.AgentWorld;
import com.mechempire.sdk.runtime.CommandMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * package: com.mechempire.agent
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/14 下午2:22
 * <p>
 * agent 主类
 */
@Slf4j
public class AgentMain implements IMechControlFlow {

    /**
     * agent 流程控制函数
     *
     * @param producer   生产者队列
     * @param team       队伍
     * @param agentWorld world
     */
    @Override
    public MechRunResult run(IProducer producer, AbstractTeam team, AgentWorld agentWorld) {
        AbstractMech mainMech = team.getMechList().get(0);
        if (!agentWorld.getEngineStatus().equals(EngineStatus.OCCUPIED)) {
            return MechRunResult.READY;
        }
        CommandMessage commandMessage = new CommandMessage();
        commandMessage.setTeamId(team.getTeamId());

        double targetX = 80.0, targetY = 80.0;
        if ((int) mainMech.getPosition().getX() == 80 && (int) mainMech.getPosition().getY() == 80) {
            targetX = 1135.0;
            targetY = 80.0;
        }

        if ((int) mainMech.getPosition().getX() == 1135 && (int) mainMech.getPosition().getY() == 80) {
            targetX = 1135.0;
            targetY = 1135.0;
        }

        if ((int) mainMech.getPosition().getX() == 1135 && (int) mainMech.getPosition().getY() == 1135) {
            targetX = 80.0;
            targetY = 1135.0;
        }

        if ((int) mainMech.getPosition().getX() == 80 && (int) mainMech.getPosition().getY() == 1135) {
            targetX = 80.0;
            targetY = 80.0;
        }
        commandMessage.appendByteSeq(mainMech.getVehicle().forward(targetX, targetY));
        producer.product(commandMessage);
        return MechRunResult.SUCCESS;
    }
}