package com.mechempire.agent;

import com.mechempire.sdk.constant.EngineStatus;
import com.mechempire.sdk.constant.MechRunResult;
import com.mechempire.sdk.core.game.AbstractMech;
import com.mechempire.sdk.core.game.AbstractTeam;
import com.mechempire.sdk.core.game.IMechControlFlow;
import com.mechempire.sdk.core.message.IProducer;
import com.mechempire.sdk.runtime.AgentWorld;
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
        Random random = new Random();
        int target = random.ints(10, 1000).findFirst().getAsInt();
        commandMessage.appendByteSeq(mainMech.getVehicle().forward(target, target));
        producer.product(commandMessage);
        return MechRunResult.SUCCESS;
    }
}