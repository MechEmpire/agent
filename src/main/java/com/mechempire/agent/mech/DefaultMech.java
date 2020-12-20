package com.mechempire.agent.mech;

import com.mechempire.sdk.core.component.CannonWeapon;
import com.mechempire.sdk.core.component.DefaultAmmunition;
import com.mechempire.sdk.core.component.DestroyerVehicle;
import com.mechempire.sdk.core.game.AbstractMech;

/**
 * package: com.mechempire.agent
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/13 下午11:08
 */
public class DefaultMech extends AbstractMech {

    /**
     * 载具类
     */
    protected Class<?> vehicleClazz = DestroyerVehicle.class;

    /**
     * 武器类
     */
    protected Class<?> weaponClazz = CannonWeapon.class;

    /**
     * 弹药类
     */
    protected Class<?> ammunitionClazz = DefaultAmmunition.class;

    @Override
    public double getBloodCount() {
        return 0;
    }
}