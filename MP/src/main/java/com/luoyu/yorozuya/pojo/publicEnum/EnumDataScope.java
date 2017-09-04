package com.luoyu.yorozuya.pojo.publicEnum;

/**
 * Created by 落羽 on 2017/8/31.
 * 可访问的数据范围
 */
public enum EnumDataScope {
    ALL("ALL"), // 所有数据
    PARTITION_AND_CHILDREN("PARTITION_AND_CHILDREN"), // 所在分区及以下数据
    PARTITION("PARTITION"), // 所在分区数据
    SECTION_AND_CHILDREN("SECTION_AND_CHILDREN"), // 所在版块及以下数据
    SECTION("SECTION"), // 所在版块数据
    SELF("SELF"), // 自身数据
    CUSTOM("CUSTOM"); // 指定细分数据
    private final String dataScope;
    private EnumDataScope(String dataScope) {
        this.dataScope = dataScope;
    }
}
