package com.kstoi.stats;

import lombok.Setter;

@Setter
public class SkillStat extends BaseStat{
    private float learningRate=1f;
    public void learn(float amount){
        this.add(amount*learningRate);
    }
}
