package com.kstoi.stats;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class BaseStat implements Serializable{
    private float current,min,max;
    public void add(float amount){
        this.current = current+amount;
        this.current = Math.min(current, max);
        this.current = Math.max(current, min);
    }
    public boolean consume(float amount){
        if(current > amount){
            this.add(-amount);
            return true;
        }else{
            return false;
        }
    }
    public void growMax(float amount){
        this.max+=amount;
    }
}
