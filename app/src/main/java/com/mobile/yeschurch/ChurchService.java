package com.mobile.yeschurch;

import java.util.ArrayList;
import java.util.List;

public class ChurchService {

    public ChurchService(){}

    public List<Church> applyKids(List<Church> churches, Boolean flag){
        List<Church> result = new ArrayList<>();

        if( !flag ){
            return churches;
        }
        for( Church churc : churches ){
            if( churc.isKids() && flag ){
                result.add(churc);
            }
        }

        return result;
    }


}
