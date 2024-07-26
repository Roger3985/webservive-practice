//
// 此檔案是由 Eclipse Implementation of JAXB, v4.0.5 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
//


package com.roger.webservice;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>currency 的 Java 類別.</p>
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.</p>
 * <pre>{@code
 * <simpleType name="currency">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="GBP"/>
 *     <enumeration value="EUR"/>
 *     <enumeration value="PLN"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "currency")
@XmlEnum
public enum Currency {

    GBP,
    EUR,
    PLN;

    public String value() {
        return name();
    }

    public static Currency fromValue(String v) {
        return valueOf(v);
    }

}
