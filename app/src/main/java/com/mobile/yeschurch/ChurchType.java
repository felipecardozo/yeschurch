package com.mobile.yeschurch;

public enum ChurchType {

    Catholic, Christian, Bauptist, Others;

    public static ChurchType getSeleted(String input){
        if( input.equalsIgnoreCase("Cristiana") ){
            return Christian;
        }
        else if( input.equalsIgnoreCase("Catolica") ){
            return Catholic;
        }
        else if( input.equalsIgnoreCase("Bautista") ) {
            return Bauptist;
        }
        return Others;
    }

}
