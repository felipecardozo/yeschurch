package com.mobile.yeschurch;

import java.util.ArrayList;
import java.util.List;

public class ChurchFilterService {

    public ChurchFilterService(){}

    public List<Church> applyKids(List<Church> churches, boolean flag, ChurchType type){
        List<Church> result = new ArrayList<>();

        if( !flag ){
            return getFullChurch(type);
        }
        for( Church churc : churches ){
            if( churc.isKids() && flag ){
                result.add(churc);
            }
        }

        return result;
    }

    public List<Church> applyParking(List<Church> churches, boolean flag, ChurchType type){
        List<Church> result = new ArrayList<>();
        if( !flag ){
            return getFullChurch(type);
        }
        for( Church churc : churches ){
            if( churc.isParking() && flag ){
                result.add(churc);
            }
        }

        return result;
    }

    public List<Church> applyBathroom(List<Church> currentList, boolean checked, ChurchType christian) {
        return Constants.christianChurches;
    }

    public List<Church> applyAccesability(List<Church> currentList, boolean checked, ChurchType christian) {
        return Constants.christianChurches;
    }

    public List<Church> applySignLanguage(List<Church> currentList, boolean checked, ChurchType christian) {
        return Constants.christianChurches;
    }

    private List<Church> getFullChurch(ChurchType type){
        if( type.equals(ChurchType.Catholic) ){
            return Constants.catholicChurches;
        }
        else if( type.equals(ChurchType.Bauptist) ){
            return Constants.bauptistChurches;
        }
        return Constants.christianChurches;
    }
}
