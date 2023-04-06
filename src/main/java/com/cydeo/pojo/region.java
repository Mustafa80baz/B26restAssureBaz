package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class region {
    //region_id  yi nasıl getRegionID olarak tanıtacağız
    @JsonProperty("region_id")
    private int regionId;
    @JsonProperty("region_name")
    private String regionName;
    @JsonProperty("links")
private List<Link>links;

}
