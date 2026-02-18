package com.kstoi.utils;

import com.kstoi.stats.CharacterArchetypes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class CharacterCreationData{
    private String custom;
    private String race;
    private String name;
    private String faction;
    private CharacterArchetypes archetype;
}
