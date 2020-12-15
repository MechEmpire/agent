package com.mechempire.agent.mech;

import com.mechempire.sdk.core.game.AbstractMech;

/**
 * package: com.mechempire.agent
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/13 下午11:08
 */
public class DefaultMech extends AbstractMech {

    public void go() {
        this.getVehicle().forward();
        System.out.printf("I'm blue, vehicle_id: %d, weapon_id: %d, ammunition_id: %d, time: %d\n",
                this.vehicleId, this.vehicleId, this.weaponId, System.currentTimeMillis());
    }
}