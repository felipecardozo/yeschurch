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

    public List<Church> applyBathroom(List<Church> churches, boolean checked, ChurchType type) {
        List<Church> result = new ArrayList<>();
        if( !checked ){
            return getFullChurch(type);
        }
        for( Church churc : churches ){
            if( churc.isBathrooms() && checked ){
                result.add(churc);
            }
        }
        return result;
    }

    public List<Church> applyAccesability(List<Church> churches, boolean checked, ChurchType type) {
        List<Church> result = new ArrayList<>();
        if( !checked ){
            return getFullChurch(type);
        }
        for( Church churc : churches ){
            if( churc.isAccessibility() && checked ){
                result.add(churc);
            }
        }
        return result;
    }

    public List<Church> applySignLanguage(List<Church> churches, boolean checked, ChurchType type) {
        List<Church> result = new ArrayList<>();
        if( !checked ){
            return getFullChurch(type);
        }
        for( Church churc : churches ){
            if( churc.isSignLanguage() && checked ){
                result.add(churc);
            }
        }
        return result;
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
