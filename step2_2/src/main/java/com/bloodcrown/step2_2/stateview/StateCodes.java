package com.bloodcrown.step2_2.stateview;

/**
 * Created by zbzbgo on 2017/12/16.
 */

public enum StateCodes {

    DATA_ERROR(-11),
    DATA_EMPTY(-12),
    NET_ERROR(-21),
    LOADING(-31),
    CONTENT(11);

    public int code;

    StateCodes(int code) {
        this.code = code;
    }
}
