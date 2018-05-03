package com.qays.bms.group;

import com.qays.bms.domain.AddEntity;
import com.qays.bms.domain.JpaTestEntity;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-03-2018 10:50
 */

public class TestGroup {
    private JpaTestEntity jte;
    private AddEntity ae;

    public JpaTestEntity getJte() {
        return jte;
    }

    public void setJte(JpaTestEntity jte) {
        this.jte = jte;
    }

    public AddEntity getAe() {
        return ae;
    }

    public void setAe(AddEntity ae) {
        this.ae = ae;
    }
}
