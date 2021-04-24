package com.mechempire.agent.mech;

import com.mechempire.sdk.constant.MapComponent;
import com.mechempire.sdk.core.game.AbstractMech;

/**
 * package: com.mechempire.agent
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/13 下午11:08
 */
public class DefaultMech extends AbstractMech {

    /**
     * 载具组件
     */
    protected MapComponent vehicleComponent = MapComponent.DESTROYER_VEHICLE;

    /**
     * 武器组件
     */
    protected MapComponent weaponComponent = MapComponent.CANNON_WEAPON;

    /**
     * 弹药组件
     */
    protected MapComponent ammunitionComponent = MapComponent.DEFAULT_AMMUNITION;

    @Override
    public double getBloodCount() {
        return 100;
    }
}