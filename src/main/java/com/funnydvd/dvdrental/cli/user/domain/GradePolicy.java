package com.funnydvd.dvdrental.cli.user.domain;

import static com.funnydvd.dvdrental.cli.user.domain.Grade.*;

/*
* 회원 등급 정책
* 5000원 이상 결제시 SIVER등급
* 7000원 이상 결제시 GOLD
* 10000원 이상 결제시 VIP
* */

public class GradePolicy {
    private static final int VIP_PRICE = 10000;
    private static final int Gold_PRICE = 7000;
    private static final int SILVER_PRICE = 5000;

    //등급 조정 기능
    public static void changeGrade(User user){
        //총 결제액에 따른 휘원 등급 조정
        int totalPaying = user.getTotalPaying();

        if(totalPaying >= VIP_PRICE){
            user.setGrade(Grade.VIP);
        }else if (totalPaying >= Gold_PRICE){
            user.setGrade(Grade.GOLD);
        }else if (totalPaying >= SILVER_PRICE){
            user.setGrade(Grade.SILVER);
        }else {
            return;
        }
    }
}