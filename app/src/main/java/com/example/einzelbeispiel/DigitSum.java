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

    String getDigitSumBinary (String mNr) throws NumberFormatException{

        int digitSum = 0;
        int digit=0;
        String binaryDigitSum;
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
            binaryDigitSum = Integer.toBinaryString(digitSum);
            return binaryDigitSum;

        }catch (NumberFormatException numberFormatException){
            Log.e("TAG", "Number format exception");
        }
        return "Please try again: your MNr is wrong.";
    }





}
