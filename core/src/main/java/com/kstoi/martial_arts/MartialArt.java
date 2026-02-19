package com.kstoi.martial_arts;

import com.kstoi.stats.SkillStat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class MartialArt{
    private String name;
    private SkillStat progress;
    private Skill[] skills = new Skill[5];
}
