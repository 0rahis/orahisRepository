package com.example.orahis.helloworld;

import android.content.res.Resources;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class BuilderPhrase {

    private  int currentTime;
    private IGetStrings iGetStrings;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public BuilderPhrase(IGetStrings iGetStrings) {
        this.currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        this.iGetStrings = iGetStrings;
    }

    public String get() {
        if (5 < currentTime && currentTime <= 10) {
            return iGetStrings.getMorning();
        } else if (10 < currentTime && currentTime <= 16) {
            return iGetStrings.getHello();
        } else  {
            return iGetStrings.getAfternoon();
        }
    }
}
