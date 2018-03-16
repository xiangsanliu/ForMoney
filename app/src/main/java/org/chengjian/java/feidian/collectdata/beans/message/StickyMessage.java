package org.chengjian.java.feidian.collectdata.beans.message;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by xiang on 2017/12/6.
 *
 */
@NoArgsConstructor
@Setter
@Getter
public class StickyMessage {

    private CityCommonAttributes cityCommonAttributes;
    private Boolean isEditable;

    public StickyMessage(CityCommonAttributes cityCommonAttributes, Boolean isEditable) {
        this.cityCommonAttributes = cityCommonAttributes;
        this.isEditable = isEditable;
    }
}
