package com.mechempire.agent;

import com.mechempire.agent.mech.DefaultMech;
import com.mechempire.sdk.core.game.AbstractMech;
import com.mechempire.sdk.core.game.AbstractTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.mechempire.agent
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/15 下午4:40
 */
public class Team extends AbstractTeam {

    /**
     * 队伍唯一 ID
     */
    protected long teamId = 2;

    /**
     * 队伍名称
     * 皮尔特沃夫
     * 德马西亚
     */
    protected String teamName = "德马西亚";
    /**
     * 机甲列表
     */
    protected List<AbstractMech> mechList;

    /**
     * 机甲类列表
     */
    protected List<Class<?>> mechClassList = new ArrayList<Class<?>>() {{
        add(DefaultMech.class);
    }};

    @Override
    public List<Class<?>> getMechClassList() {
        return mechClassList;
    }

    @Override
    public long getTeamId() {
        return teamId;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public List<AbstractMech> getMechList() {
        return mechList;
    }

    @Override
    public void setMechList(List<AbstractMech> list) {
        this.mechList = list;
    }
}