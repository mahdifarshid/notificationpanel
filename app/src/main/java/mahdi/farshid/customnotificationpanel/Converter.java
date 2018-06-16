package mahdi.farshid.customnotificationpanel;

import android.app.Activity;
import android.content.Context;
import android.view.Display;

/**
 * Created by farshid on 6/16/18.
 */

public class Converter {

    static Context context;

    public Converter(Context c) {
        context = c;
    }

   static float pixelXToPercentX(float Ex) {
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        int x = display.getWidth();
        return (Ex / x) * 100;
    }

    static float pixelYToPercentY(float Ey) {
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        int y = display.getHeight();
        return (Ey / y) * 100;
    }
}
