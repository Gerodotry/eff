package org.example.filters;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class InsuranceAFilter implements Filter {
    private Integer minPricePerMonth;
    private Integer maxPricePerMonth;
    private Integer minRisk;
    private Integer maxRisk;
    private Integer minCovered;
    private Integer maxCovered;


    public HashMap<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();

        if(this.minPricePerMonth != null){
            result.put("min_pricePerMonth", this.minPricePerMonth);
        }

        if(this.maxPricePerMonth != null){
            result.put("max_pricePerMonth", this.maxPricePerMonth);
        }

        if(this.minRisk != null){
            result.put("min_Risk", this.minRisk);
        }

        if(this.maxRisk != null){
            result.put("max_Risk", this.maxRisk);
        }

        if(this.minCovered != null){
            result.put("min_Covered", this.minCovered);
        }

        if(this.maxCovered != null){
            result.put("max_Covered", this.maxCovered);
        }

        return result;
    }
}
