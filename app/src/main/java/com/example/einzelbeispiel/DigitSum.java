package com.example.einzelbeispiel;

/*
* MNr: 01656002 % 7 = 5 ->
* Quersumme	der	Matrikelnummer	bilden	und
anschließend	als	Binärzahl	darstellen.
* */

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DigitSum extends Thread {

    int getDigitSum (String mNr) throws NumberFormatException{

        int digitSum = 0;
        int digit=0;

        List<Integer>listOfDigits=new ArrayList<>();
        try {

            //take a User Input String and convert to int
            int mNrInt = Integer.parseInt(mNr);

            //fill the list with digits
            while (mNrInt>0){
                digit=mNrInt%10;
                listOfDigits.add(digit);
                mNrInt=mNrInt/10;
            }

            for(int i:listOfDigits){
                digitSum+=i;
            }

            return digitSum;

        }catch (NumberFormatException numberFormatException){
            Log.e("TAG", "Number format exception");
        }
        return -1;
    }

    String getDigitSumBinary (int digitSum){
        String binaryDigitSum;
        if(digitSum!=-1){
            binaryDigitSum = Integer.toBinaryString(digitSum);
        }else{
            binaryDigitSum="Please try again: invalid input";
        }
        return binaryDigitSum;
    }





}
