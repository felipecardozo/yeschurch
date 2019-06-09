package com.mobile.yeschurch;

import java.util.ArrayList;
import java.util.List;

public class ChurchFilterService {

    public ChurchFilterService(){}

    public List<Church> applyKids(List<Church> churches, boolean flag){
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

    public List<Church> applyParking(List<Church> churches, boolean flag){
        List<Church> result = new ArrayList<>();
        if( !flag ){
            return churches;
        }
        for( Church churc : churches ){
            if( churc.isParking() && flag ){
                result.add(churc);
            }
        }

        return result;
    }


}
