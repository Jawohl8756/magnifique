package com.wunderbar.BuildModel.VisitorPattern;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Rommel
 * @date 2020/3/16 13:24
 * @description
 */

@Setter
@Getter
public class ProjectElement implements Element {

    private String ProjectName ;

    private String ProjectContent ;

    private String visitorName ;

    private Date visitTime ;

    public ProjectElement(String projectName, String projectContent) {
        ProjectName = projectName;
        ProjectContent = projectContent;

    }

    public void accept(Visitor visitor) {
        visitor.visit(this);

    }

    public void signature(String visitorName,Date visitTime){


    }
}
