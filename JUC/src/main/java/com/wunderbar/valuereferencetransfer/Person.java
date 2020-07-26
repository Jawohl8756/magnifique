package com.wunderbar.valuereferencetransfer;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rommel
 * @date 2020/2/29 21:20
 * @description
 */


@Data
@Getter
@Setter
@NoArgsConstructor
public class Person {

    private Integer id ;

    private String personName ;

    public Person(String personName){
        this.personName = personName;

    }
}
